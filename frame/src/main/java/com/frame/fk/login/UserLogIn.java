package com.frame.fk.login;

import android.content.Context;
import android.text.TextUtils;

import com.frame.fk.frame.Model;

/**
 * 根据String标签生成登录的具体对象
 */
public abstract class UserLogIn extends Model implements ILogInModel {
    /**
     * 登录的方式
     */
    private String mDefaultLogInStyle = LogInStyle.APP;

    public UserLogIn(Context context, String logInStyle) {
        this.mAppContext = context.getApplicationContext();

        if (!TextUtils.isEmpty(logInStyle)) this.mDefaultLogInStyle = logInStyle;
    }

    /**
     *
     * @param style
     * @return
     */
    @Override
    public abstract ILogIn getLogInModelByName(String style) ;

    /**
     * 用户登录状态判断
     * @return
     */
    @Override
    public abstract boolean isUserLogIn();
}
