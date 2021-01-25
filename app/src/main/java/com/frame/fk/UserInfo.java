package com.frame.fk;

public class UserInfo {
    private static String mUserId ;

    public static String getUserId() {
        return mUserId;
    }

    public static void setUserId(String id) {
        mUserId = id;
    }
}
