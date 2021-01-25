package com.frame.fk.frame;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public class Model {

    protected Context mActContext, mAppContext;
    protected Activity mActivity;
    protected AppCompatActivity mAppCompatActivity;

    public Model(){}

    public Model(Context context) {
        mAppContext = context.getApplicationContext();
    }

    public Model(Activity activity) {
        mActivity = activity;
        mActContext = activity;
        mAppContext = activity.getApplicationContext();
    }

    public Model(AppCompatActivity appCompatActivity) {
        mAppCompatActivity = appCompatActivity;
        mActContext = mAppCompatActivity;
        mAppContext = mAppCompatActivity.getApplicationContext();
    }

    public Context getActContext() {
        return mActContext;
    }

    public void setActContext(Context mActContext) {
        this.mActContext = mActContext;
    }

    public Context getAppContext() {
        return mAppContext;
    }

    public void setAppContext(Context mAppContext) {
        this.mAppContext = mAppContext;
    }

    public Activity getActivity() {
        return mActivity;
    }

    public void setActivity(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public AppCompatActivity getAppCompatActivity() {
        return mAppCompatActivity;
    }

    public void setAppCompatActivity(AppCompatActivity mAppCompatActivity) {
        this.mAppCompatActivity = mAppCompatActivity;
    }
}
