package com.mvvm.base.utils;

import android.Manifest.permission;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class LocationUtils {
    public static Double[] getCurLocation(Context context) {
        Double[] point = new Double[2];
        //获取系统定位
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, new LocationListener() {
            //当位置改变的时候调用
            @Override
            public void onLocationChanged(Location location) {

                //经度
                point[0] = location.getLongitude();
                //纬度
                point[1] = location.getLatitude();

                //海拔
                double altitude = location.getAltitude();
                UtilsLog.d("zhm", "lon:" + point[0] + "   lat:" + point[1]);

            }

            //当GPS状态发生改变的时候调用
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {


                switch (status) {

                    case LocationProvider.AVAILABLE:
                        ToastUtil.show("当前GPS为可用状态!");

                        break;

                    case LocationProvider.OUT_OF_SERVICE:
                        ToastUtil.show("当前GPS不在服务内!");

                        break;

                    case LocationProvider.TEMPORARILY_UNAVAILABLE:
                        ToastUtil.show("当前GPS为暂停服务状态!");
                        break;


                }

            }

            //GPS开启的时候调用
            @Override
            public void onProviderEnabled(String provider) {
                ToastUtil.show("GPS开启了!");

            }

            //GPS关闭的时候调用
            @Override
            public void onProviderDisabled(String provider) {
                ToastUtil.show("GPS关闭了!");

            }
        });
        return point;
    }
}
