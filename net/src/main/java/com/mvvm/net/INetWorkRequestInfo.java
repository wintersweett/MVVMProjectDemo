package com.mvvm.net;

import java.util.HashMap;
/**
* @author :WinterSweett
 * @description
 *
*/
public interface INetWorkRequestInfo {
    HashMap<String,String> getRequestHeaderMap();
    boolean isDebug();
}
