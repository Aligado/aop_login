package com.frame.fk.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.frame.fk.frame.Model;

/**
 * 通过App账号登录
 */
public class AppAcctLogIn extends Model implements ILogIn, IAppAcctLogIn {

    public static final String BUNDLE_NAME = "LOGIN_BUNDLE";
    public static final String ACCT_INFO = "ACCT_INFO";

    private Class mTargetClass;
    private String mAcctInfo;

    public AppAcctLogIn(Context context) {
        super(context);
    }

    @Override
    public void onLogIn() {
        Toast.makeText(mAppContext, "APP账号登录", Toast.LENGTH_SHORT).show();
        if (mTargetClass == null) return;

        Intent intent = new Intent(mAppContext, mTargetClass);


        if (!TextUtils.isEmpty(mAcctInfo)) {
            Bundle bundle = new Bundle();
            bundle.putString(ACCT_INFO, mAcctInfo);
            intent.putExtra(BUNDLE_NAME, bundle);
        }

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );

        mAppContext.startActivity(intent);
    }

    @Override
    public void onAppLogIn(Class c, String defaultUserAcct) {
        this.mTargetClass = c;
        this.mAcctInfo = defaultUserAcct;
    }
}
