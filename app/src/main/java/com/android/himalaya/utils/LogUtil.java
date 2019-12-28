package com.android.himalaya.utils;

import android.util.Log;

/**
 * create by Administrator
 * on 2019/12/24 0024
 */
public class LogUtil {

    public static String sTAG = "LogUtil";

    //控制是否要输出log,
    public static boolean sIsRelease = false;

    /**
     * 在BaseApplication中初始化
     * 如果发布版本不需要log，将sIsRelease改为true即可
     * @param baseTAG
     * @param isRelease
     */
    public static void  init(String baseTAG , boolean isRelease){
        sTAG = baseTAG;
        sIsRelease = isRelease;
    }

    public static void d(String TAG, String content){
        if (!sIsRelease){
            Log.d( "[" + sTAG +"]" + TAG,content);
        }
    }

    public static void v(String TAG, String content){
        if (!sIsRelease){
            Log.d( "[" + sTAG +"]" + TAG,content);
        }
    }
    public static void i(String TAG, String content){
        if (!sIsRelease){
            Log.d( "[" + sTAG +"]" + TAG,content);
        }
    }
    public static void e(String TAG, String content){
        if (!sIsRelease){
            Log.d( "[" + sTAG +"]" + TAG,content);
        }
    }
    public static void w(String TAG, String content){
        if (!sIsRelease){
            Log.d( "[" + sTAG +"]" + TAG,content);
        }
    }
}
