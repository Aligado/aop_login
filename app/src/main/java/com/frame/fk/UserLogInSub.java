package com.frame.fk;

import android.content.Context;
import android.text.TextUtils;

import com.frame.fk.login.AppAcctLogIn;
import com.frame.fk.login.UserLogIn;
import com.frame.fk.login.ILogIn;
import com.frame.fk.login.LogInStyle;

public class UserLogInSub extends UserLogIn {
    public UserLogInSub(Context context, String logInStyle) {
        super(context, logInStyle);
    }

    @Override
    public ILogIn getLogInModelByName(String style) {
        switch (style) {
            case LogInStyle.APP:
                AppAcctLogIn appAcctLogIn = new AppAcctLogIn(mAppContext);
                appAcctLogIn.onAppLogIn(LogInActivity.class, null);
                return appAcctLogIn;
            case LogInStyle.APAY:
                return new ALogIn(mAppContext);
        }

        return null;
    }

    @Override
    public boolean isUserLogIn() {
        return !TextUtils.isEmpty(UserInfo.getUserId());
    }
}
