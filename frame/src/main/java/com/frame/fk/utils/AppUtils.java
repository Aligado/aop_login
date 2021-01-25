package com.frame.fk.utils;

import android.content.Context;

public class AppUtils {
    private static Context mAppContext;

    public AppUtils(){}

    public AppUtils(Context context) {
        this.mAppContext = context;
    }

    public static Context getAppContext() {
        return mAppContext;
    }
}
