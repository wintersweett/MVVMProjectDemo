package com.mvvm.common.utils;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

import androidx.core.content.FileProvider;

import com.mvvm.base.utils.StringUtils;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class TakePicUtils {

    public static void getPicsFromGallery(Activity context){
        //开启图库获取照片
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
       // intent.setType("image/*");
        context.startActivityForResult(intent, ConstantPic.PHOTO_REQUEST_GALLERY);//携带请求码
    }
    public static final int RC_TAKE_PHOTO = 1;

    private String mTempPhotoPath;
    private Uri imageUri;
    public void takePhoto(Activity context) {
        Intent intentToTakePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File fileDir = new File(Environment.getExternalStorageDirectory() + File.separator + "photoTest" + File.separator);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        File photoFile = new File(fileDir, "photo.jpeg");
        mTempPhotoPath = photoFile.getAbsolutePath();
       // imageUri = FileProvider7.getUriForFile(this, photoFile);
        intentToTakePhoto.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        context.startActivityForResult(intentToTakePhoto, RC_TAKE_PHOTO);
    }

    public static void getPicsFromPhoto(Activity context){
         File tempFile = getTempPath();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (hasSdcard()) {// 判断存储卡是否可以用，可用进行存储
           // tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME);
           // Uri uri = Uri.fromFile(tempFile); // 从文件中创建uri
           // intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }
//        Uri uri = uriFromFile(context,tempFile);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(
                new File(Environment.getExternalStorageDirectory(), "img")));
        context.startActivityForResult(intent, ConstantPic.PHOTO_REQUEST_CAREMA);//携带请求码
    }
    private static boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    private static void crop(Uri uri , Activity context) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);
        context.startActivityForResult(intent, ConstantPic.PHOTO_REQUEST_CUT); // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
    }
//    private Uri external(String external) {
//        String myImageUrl = "content://media" + external;
//        Uri uri = Uri.parse(myImageUrl);
//        String[] proj = {MediaStore.Images.Media.DATA};
//      //  Cursor actualimagecursor = this.managedQuery(uri, proj, null, null, null);
////        int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
////        actualimagecursor.moveToFirst();
//       String img_path = actualimagecursor.getString(actual_image_column_index);
//        File file = new File(img_path);
//        Uri fileUri = Uri.fromFile(file);
//        return fileUri;
//    }
    /**
     * 获取路径
     *
     * @return
     */
    public static File getTempPath() {
        File tempFile = null;
        if (checkSDCard()) {
            File dirFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                    + ConstantPic.PIC_CACHE_DIR_PATH);
            tempFile = new File(dirFile, System.currentTimeMillis() + ".jpg");
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
        }
        return tempFile;
    }
    /**
     * 检查sd卡
     *
     * @return
     */
    public static boolean checkSDCard() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 浏览手机相册
     *
     * @return
     */
    public static Intent createAlbumIntent() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        Intent chooseIntent = Intent.createChooser(intent, null);
        return chooseIntent;
    }
    /**
     * 拍照后照片旋转90度的，转正后，再放回原处
     *
     * @param imagePath
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void rotate90(String imagePath) throws IOException,
            FileNotFoundException {
        ExifInterface exifInterface = new ExifInterface(imagePath);
        String orientation = exifInterface
                .getAttribute(ExifInterface.TAG_ORIENTATION);
        if ("6".equals(orientation)) { // 拍照后照片旋转了90度
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            File file = new File(imagePath);
            // 数字越大读出的图片占用的heap越小 不然总是溢出
            if (file.length() < 20480) { // 0-20k
                options.inSampleSize = 1;
            } else if (file.length() < 51200) { // 20-50k
                options.inSampleSize = 1;
            } else if (file.length() < 307200) { // 50-300k
                options.inSampleSize = 1;
            } else if (file.length() < 819200) { // 300-800k
                options.inSampleSize = 2;
            } else if (file.length() < 1048576) { // 800-1024k
                options.inSampleSize = 3;
            } else {
                options.inSampleSize = 4;
            }
            Bitmap res = BitmapFactory.decodeFile(imagePath, options);
            Matrix matrix = new Matrix();
            matrix.postRotate(90);
            Bitmap bitmap = Bitmap.createBitmap(res, 0, 0, res.getWidth(),
                    res.getHeight(), matrix, true);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,
                    new FileOutputStream(new File(imagePath)));
        }
    }
    /**
     * 通过Uri传递图像信息以供裁剪
     * @param uri
     */
    public static void startImageZoom(Uri uri,Activity context){
        //构建隐式Intent来启动裁剪程序
        Intent intent = new Intent("com.android.camera.action.CROP");
        //设置数据uri和类型为图片类型
        intent.setDataAndType(uri, "image/*");
        //显示View为可裁剪的
        intent.putExtra("crop", true);
        //裁剪的宽高的比例为1:1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //输出图片的宽高均为150
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        //裁剪之后的数据是通过Intent返回
        intent.putExtra("return-data", true);
        context.startActivityForResult(intent, ConstantPic.PHOTO_REQUEST_CUT);
    }

    /**
     * 将Bitmap写入SD卡中的一个文件中,并返回写入文件的Uri
     * @param bm
     * @param dirPath
     * @return
     */
    public static Uri saveBitmap(Bitmap bm, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        File tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        Log.d("zhm","path : "+Environment.getExternalStorageDirectory()+"/"+dirPath);
        if (!tmpDir.exists()){
            tmpDir.mkdir();
        }

        //新建文件存储裁剪后的图片
        File img = new File(tmpDir.getAbsolutePath() + "/avator.png");
        try {
            //打开文件输出流
            FileOutputStream fos = new FileOutputStream(img);
            //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            bm.compress(Bitmap.CompressFormat.PNG, 85, fos);
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
            //返回File类型的Uri
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 将content类型的Uri转化为文件类型的Uri
     * @param uri
     * @return
     */
    public static Uri convertUri(Uri uri, Context context){
        InputStream is;
        try {
            //Uri ----> InputStream
            is = context.getContentResolver().openInputStream(uri);
            //InputStream ----> Bitmap
            Bitmap bm = BitmapFactory.decodeStream(is);
            //关闭流
            is.close();
            return saveBitmap(bm, "temp");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从文件获得URI
     * @param activity 上下文
     * @param file 文件
     * @return 文件对应的URI
     */
    public static Uri uriFromFile(Activity activity, File file) {
        Uri fileUri;
        //7.0以上进行适配
        if (Build.VERSION.SDK_INT >= 24) {
            String p = activity.getPackageName() + ".fileprovider";
            fileUri = FileProvider.getUriForFile(
                    activity,
                    p,
                    file);
        } else {
            fileUri = Uri.fromFile(file);
        }
        return fileUri;
    }
    /**
     * 按图片大小(字节大小)压缩图片
     *
     * @param path
     * @return
     */
    public static Bitmap fitSizeImg(String path) {
        if (path == null || path.length() < 1) return null;
        File file = new File(path);
        Bitmap resizeBmp = null;
        BitmapFactory.Options opts = new BitmapFactory.Options();
        // 数字越大读出的图片占用的heap越小 不然总是溢出
        if (file.length() < 20480) {       // 0-20k
            opts.inSampleSize = 1;
        } else if (file.length() < 51200) { // 20-50k
            opts.inSampleSize = 2;
        } else if (file.length() < 307200) { // 50-300k
            opts.inSampleSize = 4;
        } else if (file.length() < 819200) { // 300-800k
            opts.inSampleSize = 6;
        } else if (file.length() < 1048576) { // 800-1024k
            opts.inSampleSize = 8;
        } else {
            opts.inSampleSize = 10;
        }
        resizeBmp = BitmapFactory.decodeFile(file.getPath(), opts);
        return resizeBmp;
    }
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }
    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static String getPath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= 19;

        // DocumentProvider
        if (isKitKat ) {
            // ExternalStorageProvider-----没用
            if (isExternalStorageDocument(uri)) {
                String docId = URLDecoder.decode(uri.toString());
                if(docId.startsWith("/document")){
                    docId = docId.replace("/document/", "").trim();
                }
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                // TODO handle non-primary volumes
            }
            // DownloadsProvider-----没用
            else if (isDownloadsDocument(uri)) {
                String id = URLDecoder.decode(uri.toString());
                if(id.startsWith("/document")){
                    id = id.replace("/document/", "").trim();
                }
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider-----图片只走这个方法
            else if (isMediaDocument(uri)) {
                String docId = URLDecoder.decode(uri.getPath());
                if(docId.startsWith("/document")){
                    docId = docId.replace("/document/", "").trim();
                }
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[] {
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();

            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }
    public static boolean isImage(String url) {
        if (StringUtils.isNullOrEmpty(url)) {
            return false;
        }
        if (url.indexOf("images") > 0) {
            return true;
        } else {
            if (url.endsWith(".jpg") || url.endsWith(".png")) {
                return true;
            }
        }
        return false;
    }
    public static void CopyStream(InputStream is, OutputStream os) {
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (; ; ) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
        } catch (Exception ex) {
        }
    }
    public static String convertStream2File(InputStream is) {
        File file = getTempPath();
        final String filePath = file.getAbsolutePath();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            CopyStream(is, fos);
            is.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
