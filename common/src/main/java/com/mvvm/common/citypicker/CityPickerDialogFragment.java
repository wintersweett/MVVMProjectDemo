package com.mvvm.common.citypicker;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.common.R;
import com.mvvm.common.beans.FuxunIndexResponse;
import com.mvvm.common.citypicker.adapter.CityListAdapter;
import com.mvvm.common.citypicker.adapter.InnerListener;
import com.mvvm.common.citypicker.adapter.OnPickListener;
import com.mvvm.common.citypicker.adapter.decoration.DividerItemDecoration;
import com.mvvm.common.citypicker.adapter.decoration.SectionItemDecoration;
import com.mvvm.common.citypicker.db.DBManager;
import com.mvvm.common.citypicker.model.City;
import com.mvvm.common.citypicker.model.HotCity;
import com.mvvm.common.citypicker.model.LocatedCity;
import com.mvvm.common.citypicker.util.ScreenUtil;
import com.mvvm.common.citypicker.view.SideIndexBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 付训酒店 所有城市页面
 */
public class CityPickerDialogFragment extends DialogFragment implements TextWatcher,
        View.OnClickListener, SideIndexBar.OnIndexTouchedChangedListener, InnerListener {
    private View mContentView;
    private RecyclerView mRecyclerView;
    private View mEmptyView;
    private TextView mOverlayTextView;
    private SideIndexBar mIndexBar;
    private EditText mSearchBox;
    private TextView mCancelBtn;
    private ImageView mClearAllBtn;

    private LinearLayoutManager mLayoutManager;
    private CityListAdapter mAdapter;
    private List<City> mAllCities = new ArrayList<>();
    private List<HotCity> mHotCities;
    private List<City> mResults = new ArrayList<>();

    private DBManager dbManager;

    private int height;
    private int width;

    private boolean enableAnim = false;
    private int mAnimStyle = R.style.DefaultCityPickerAnimation;
    private LocatedCity mLocatedCity;
    private int locateState;
    private OnPickListener mOnPickListener;

    /**
     * 获取实例
     * @param enable 是否启用动画效果
     * @return
     */
    public static CityPickerDialogFragment newInstance(boolean enable){
        final CityPickerDialogFragment fragment = new CityPickerDialogFragment();
        Bundle args = new Bundle();
        args.putBoolean("cp_enable_anim", enable);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.CityPickerStyle);

    }

    public void setLocatedCity(LocatedCity location){
        mLocatedCity = location;
    }

    public void setHotCities(List<HotCity> data){
        if (data != null && !data.isEmpty()){
            this.mHotCities = data;
        }
    }

    @SuppressLint("ResourceType")
    public void setAnimationStyle(@StyleRes int resId){
        this.mAnimStyle = resId <= 0 ? mAnimStyle : resId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.cp_dialog_city_picker, container, false);
        View view = mContentView.findViewById(R.id.header_city);
        TextView tv_title = view.findViewById(R.id.tv_title);
        tv_title.setText("选择城市");
        view.findViewById(R.id.iv_back).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnPickListener != null){
                    mOnPickListener.onCancel();
                }
                if(dialog != null){
                    dialog.dismiss();
                }
            }
        });
        return mContentView;
    }
    /**
     * 是否在Fragment使用沉浸式
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }
    /**
     * 初始化沉浸式
     */
    protected void initImmersionBar() {
        ImmersionBar.with(this).init();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }
        initData();
        initViews();
        EventBus.getDefault().register(this);
    }

    private void initViews() {
        mRecyclerView = mContentView.findViewById(R.id.cp_city_recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new SectionItemDecoration(getActivity(), mAllCities), 0);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity()), 1);
        mAdapter = new CityListAdapter(getActivity(), mAllCities, mHotCities, locateState);
        mAdapter.autoLocate(false);
        mAdapter.setInnerListener(this);
        mAdapter.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                //确保定位城市能正常刷新
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    mAdapter.refreshLocationItem();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            }
        });

        mEmptyView = mContentView.findViewById(R.id.cp_empty_view);
        mOverlayTextView = mContentView.findViewById(R.id.cp_overlay);

        mIndexBar = mContentView.findViewById(R.id.cp_side_index_bar);
        mIndexBar.setNavigationBarHeight(ScreenUtil.getNavigationBarHeight(getActivity()));
        mIndexBar.setOverlayTextView(mOverlayTextView)
                .setOnIndexChangedListener(this);

        mSearchBox = mContentView.findViewById(R.id.cp_search_box);
        mSearchBox.addTextChangedListener(this);

        mCancelBtn = mContentView.findViewById(R.id.cp_cancel);
        mClearAllBtn = mContentView.findViewById(R.id.cp_clear_all);
        mCancelBtn.setOnClickListener(this);
        mClearAllBtn.setOnClickListener(this);
    }

    private void initData() {
        Bundle args = getArguments();
        if (args != null) {
            enableAnim = args.getBoolean("cp_enable_anim");
        }
        //初始化热门城市
        if (mHotCities == null || mHotCities.isEmpty()) {
            mHotCities = new ArrayList<>();
            mHotCities.add(new HotCity("北京", "北京", "101010100"));
            mHotCities.add(new HotCity("上海", "上海", "101020100"));
            mHotCities.add(new HotCity("广州", "广东", "101280101"));
            mHotCities.add(new HotCity("深圳", "广东", "101280601"));
            mHotCities.add(new HotCity("天津", "天津", "101030100"));
            mHotCities.add(new HotCity("杭州", "浙江", "101210101"));
            mHotCities.add(new HotCity("南京", "江苏", "101190101"));
            mHotCities.add(new HotCity("成都", "四川", "101270101"));
            mHotCities.add(new HotCity("武汉", "湖北", "101200101"));
        }
        //初始化定位城市，默认为空时会自动回调定位
//        if (mLocatedCity == null){
//            mLocatedCity = new LocatedCity(getString(R.string.cp_locating), "未知", "0");
//            locateState = LocateState.LOCATING;
//        }else{
//            locateState = LocateState.SUCCESS;
//        }

        dbManager = new DBManager(getActivity());
        //TODO暂时不从数据库中取 。暂时从接口。以后：将接口数据存入数据库，监听接口所有城市是否有变化，有的话再存入数据库
        //mAllCities = dbManager.getAllCities(); //获取所有城市
        //从后端接口获取的数据
       // mAllCities = getAllCititiesFromServer();
       // mAllCities.add(0, mLocatedCity);  //定位城市
        mAllCities.add(0, new HotCity("热门城市", "未知", "0")); //热门城市
        mResults = mAllCities;
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getAll(FuxunIndexResponse.DataBean.CityListBean response){
        for(FuxunIndexResponse.DataBean.CityListBean.ABean aBean : response.getA()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.BBean aBean : response.getB()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.CBean aBean : response.getC()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.DBean aBean : response.getD()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.EBean aBean : response.getE()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.FBean aBean : response.getF()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.GBean aBean : response.getG()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.HBean aBean : response.getH()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.JBean aBean : response.getJ()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.KBean aBean : response.getK()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.LBean aBean : response.getL()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.MBean aBean : response.getM()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.NBean aBean : response.getN()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.PBean aBean : response.getP()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.QBean aBean : response.getQ()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.RBean aBean : response.getR()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.SBean aBean : response.getS()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.TBean aBean : response.getT()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.WBean aBean : response.getW()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.XBean aBean : response.getX()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.YBean aBean : response.getY()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        for(FuxunIndexResponse.DataBean.CityListBean.ZBean aBean : response.getZ()){
            City city = new City(aBean.getBrief(),aBean.getPname(),aBean.getFirstLetter(),aBean.getId()) ;
            mAllCities.add(city);
        }
        mResults = mAllCities;
    }

    Dialog dialog ;
    @Override
    public void onStart() {
        super.onStart();
         dialog = getDialog();
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK){
                    if (mOnPickListener != null){
                        mOnPickListener.onCancel();
                    }
                }
                return false;
            }
        });

        measure();
        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
            window.setGravity(Gravity.BOTTOM);
           // window.setLayout(width, height - ScreenUtil.getStatusBarHeight(getActivity()));
            window.setLayout(width,height);
            if (enableAnim) {
                window.setWindowAnimations(mAnimStyle);
            }
        }
    }

    //测量宽高
    private void measure() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(dm);
            height = dm.heightPixels;
            width = dm.widthPixels;
        }else{
            DisplayMetrics dm = getResources().getDisplayMetrics();
            height = dm.heightPixels;
            width = dm.widthPixels;
        }
    }

    /** 搜索框监听 */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        String keyword = s.toString();
        if (TextUtils.isEmpty(keyword)){
            mClearAllBtn.setVisibility(View.GONE);
            mEmptyView.setVisibility(View.GONE);
            mResults = mAllCities;
            ((SectionItemDecoration)(mRecyclerView.getItemDecorationAt(0))).setData(mResults);
            mAdapter.updateData(mResults);
        }else {
            mClearAllBtn.setVisibility(View.VISIBLE);
            //TODO 暂时不在数据库查找 开始数据库查找
           // mResults = dbManager.searchCity(keyword);
            mResults = searchKeyWordsByLcs(keyword) ;
            ((SectionItemDecoration)(mRecyclerView.getItemDecorationAt(0))).setData(mResults);
            if (mResults == null || mResults.isEmpty()){
                mEmptyView.setVisibility(View.VISIBLE);
            }else {
                mEmptyView.setVisibility(View.GONE);
                mAdapter.updateData(mResults);
            }
        }
        mRecyclerView.scrollToPosition(0);
    }
    public List<City> searchKeyWordsByLcs(String keyWord){
        List<City> res = new ArrayList<>();
        if(mAllCities.size() == 0)return null;
        for(City city : mAllCities){
           int c = LongestCommonSubsequence.longestCommonSubsequence(city.getName(),keyWord);
           if(c > 0){
               res.add(city) ;
           }
        }

        return res ;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.cp_cancel) {
            dismiss();
            if (mOnPickListener != null){
                mOnPickListener.onCancel();
            }
        }else if(id == R.id.cp_clear_all){
            mSearchBox.setText("");
        }
    }


    @Override
    public void onIndexChanged(String index, int position) {
        //滚动RecyclerView到索引位置
        mAdapter.scrollToSection(index);
    }

    public void locationChanged(LocatedCity location, int state){
        mAdapter.updateLocateState(location, state);
    }

    @Override
    public void dismiss(int position, City data) {
        dismiss();
        if (mOnPickListener != null){
            mOnPickListener.onPick(position, data);
        }
    }

    @Override
    public void locate(){
        if (mOnPickListener != null){
            mOnPickListener.onLocate();
        }
    }

    public void setOnPickListener(OnPickListener listener){
        this.mOnPickListener = listener;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
