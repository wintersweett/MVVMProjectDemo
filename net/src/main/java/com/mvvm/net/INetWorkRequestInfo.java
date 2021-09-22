package com.mvvm.net;

import java.util.HashMap;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public interface INetWorkRequestInfo {
    HashMap<String,String> getRequestHeaderMap();
    boolean isDebug();
}
