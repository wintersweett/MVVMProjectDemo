package com.mvvm.base.model;

import android.text.TextUtils;

import com.mvvm.base.preference.BasicDataPreferenceUtil;
import com.mvvm.base.utils.GenericUtils;
import com.mvvm.base.utils.GsonUtils;
import com.mvvm.base.utils.UtilsLog;

import org.json.JSONObject;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import androidx.annotation.CallSuper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
/**
* @author :WinterSweett
 * @description
 *
*/
public abstract class BaseModel<F, T> implements BaseNetWorkObserver<F> {
    private CompositeDisposable compositeDisposable;
    protected ReferenceQueue<IBaseModelListener> mReferenceQueue;
    protected ConcurrentLinkedQueue<WeakReference<IBaseModelListener>> mWeakListenerArrayList;
    private BaseCachedData<F> mData;
    protected int pageNumber = 1;
    private String mCachedPreferenceKey;
    private String mApkPredefinedData;
    private boolean mIsPaging;
    private Class<F> clazz;
    private final int INIT_PAGE_NUMBER;
    private boolean mIsLoading;

    public BaseModel(Class<F> clazz, boolean isPaging, String cachePreferenceKey, String apkPredefinedData, int... initPageNumber) {
        this.mIsPaging = isPaging;
        this.clazz = clazz;
        this.INIT_PAGE_NUMBER = (initPageNumber != null && initPageNumber.length > 0) ? initPageNumber[0] : 0;
        if (initPageNumber != null && initPageNumber.length > 0) {
            this.pageNumber = initPageNumber[0];
        }
        this.mCachedPreferenceKey = cachePreferenceKey;
        this.mApkPredefinedData = apkPredefinedData;
        mReferenceQueue = new ReferenceQueue<>();
        mWeakListenerArrayList = new ConcurrentLinkedQueue<>();
//        if (mCachedPreferenceKey != null) {
//            mData = new BaseCachedData<F>();
//        }
    }
    public void loadNextPage(){
        if(!mIsLoading){
            mIsLoading = true ;
            load();
        }
    }

    public boolean isPaging() {
        return mIsPaging;
    }

    /**
     * ????????????
     *
     * @param listener
     */
    public void register(IBaseModelListener listener) {
        if (listener == null) {
            return;
        }

        synchronized (this) {
            // ?????????????????????????????????????????????????????????
            Reference<? extends IBaseModelListener> releaseListener = null;
            while ((releaseListener = mReferenceQueue.poll()) != null) {
                mWeakListenerArrayList.remove(releaseListener);
            }

            for (WeakReference<IBaseModelListener> weakListener : mWeakListenerArrayList) {
                IBaseModelListener listenerItem = weakListener.get();
                if (listenerItem == listener) {
                    return;
                }
            }
            WeakReference<IBaseModelListener> weakListener = new WeakReference<IBaseModelListener>(listener, mReferenceQueue);
            mWeakListenerArrayList.add(weakListener);
        }

    }

    /**
     * ????????????
     *
     * @param listener
     */
    public void unRegister(IBaseModelListener listener) {

        if (listener == null) {
            return;
        }
        synchronized (this) {
            for (WeakReference<IBaseModelListener> weakListener : mWeakListenerArrayList) {
                IBaseModelListener listenerItem = weakListener.get();
                if (listener == listenerItem) {
                    mWeakListenerArrayList.remove(weakListener);
                    break;
                }
            }
        }
    }
    /**?????????App????????????????????????app????????????????????????????????????????????????????????????????????????app???????????????????????????
     * ??????????????????????????????????????????????????????????????????????????????app???????????????preference????????????????????????
     *      * apk?????????????????????????????????????????????????????????app??????????????????????????????????????????????????????????????????
     * @param data
     */
    protected void saveDataToPreference(F data) {
        if (data != null) {
            BaseCachedData<F> cachedData = new BaseCachedData<>();
            cachedData.data = data;
            cachedData.updateTimeInMills = System.currentTimeMillis();
            BasicDataPreferenceUtil.getInstance().setString(mCachedPreferenceKey, GsonUtils.getLocalGson().toJson(cachedData));
        }
    }

    public void refresh(){
        if(!mIsLoading){
            if(isPaging()){
                pageNumber = INIT_PAGE_NUMBER;
            }
            load();
        }

    }
/**
 * @param:
*????????????
*/
    public abstract void load();

    /**
     * ????????????????????????????????????????????????????????????????????????????????????????????????
     * ??????????????????????????????
     */
    protected boolean isNeedToUpdate(long cachedTimeSlot) {
        UtilsLog.d("ws","cacheckTimeSlot:start:"+cachedTimeSlot);
       Long endTime = System.currentTimeMillis();
        UtilsLog.d("ws","cacheckTimeSlot:end:"+endTime);
        return true;
    }

    @CallSuper
    public void cancel() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }


    public void addDisposable(Disposable d) {
        if (d == null) {
            return;
        }

        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }

        compositeDisposable.add(d);
    }

    public void getCachedDataAndLoad() {
        if (!mIsLoading) {
            mIsLoading = true;
            if (mCachedPreferenceKey != null) {
                String saveDataString = BasicDataPreferenceUtil.getInstance().getString(mCachedPreferenceKey);
                if (!TextUtils.isEmpty(saveDataString)) {
                    try {
                        F savedData = GsonUtils.getLocalGson().fromJson(new JSONObject(saveDataString).getString("data"), (Class<F>) GenericUtils.getGenericType(this));
                        if (savedData != null) {
                            onSuccess(savedData, true);
                        }
                        long timeSlot = Long.parseLong(new JSONObject(saveDataString).getString("updateTimeInMillis"));
                        if (isNeedToUpdate(timeSlot)) {
                            load();
                        }
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (mApkPredefinedData != null) {
                    try {
                        F savedData = GsonUtils.getLocalGson().fromJson(mApkPredefinedData, (Class<F>) GenericUtils.getGenericType(this));
                        if (savedData != null && savedData != null) {
                            onSuccess(savedData, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            load();
        }
    }
    /**
     * ????????????UI??????
     */
    //TODO
    protected void notifyResultToListeners(F networkResonseBean, T data, boolean isFromCache) {
        synchronized (this) {
            for (WeakReference<IBaseModelListener> weakListener : mWeakListenerArrayList) {
                if (weakListener.get() instanceof IBaseModelListener) {
                    IBaseModelListener listenerItem = weakListener.get();
                    if (listenerItem != null) {
                        if (isPaging()) {
                                listenerItem.onLoadFinish(this, data,
                                        isFromCache ? new PagingResult(false, true, true) :
                                            new PagingResult(data == null ? true : ((List) data).isEmpty(), pageNumber == INIT_PAGE_NUMBER, data == null ? false : ((List) data).size() > 0));
                        } else {
                            listenerItem.onLoadFinish(this, data);
                        }

                        // save resultData to preference
                        if(mIsPaging) {
                            if(mCachedPreferenceKey != null && pageNumber == INIT_PAGE_NUMBER && !isFromCache){
                                saveDataToPreference(networkResonseBean);
                            }
                        } else {
                            if(mCachedPreferenceKey != null && !isFromCache){
                                saveDataToPreference(networkResonseBean);
                            }
                        }

                        // update page number
                        if (mIsPaging && !isFromCache) {
                            if (data != null && ((List) data).size() > 0) {
                                pageNumber++;
                            }
                        }
                    }


                    if(!isFromCache) {
                        mIsLoading = false;
                    }
                }
            }
        }
    }



    protected void loadFail(final String errorMessage) {
        synchronized (this) {
            for (WeakReference<IBaseModelListener> weakListener : mWeakListenerArrayList) {
                if (weakListener.get() instanceof IBaseModelListener) {
                    IBaseModelListener listenerItem = weakListener.get();
                    if (listenerItem != null) {
                        if (isPaging()) {
                            listenerItem.onLoadFail(this, errorMessage, new PagingResult(true, pageNumber == INIT_PAGE_NUMBER, false));
                        } else {
                            listenerItem.onLoadFail(this, errorMessage);
                        }
                    }
                    mIsLoading = false;
                }
            }
        }
    }

    protected boolean isRefresh() {
        return pageNumber == INIT_PAGE_NUMBER;
    }
}
