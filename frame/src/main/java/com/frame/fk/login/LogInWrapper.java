package com.frame.fk.login;

import android.content.Context;
import com.frame.fk.frame.Model;


/**
 * 登录管理的封装
 */
public class LogInWrapper extends Model implements ILogIn {
    private static ILogIn mILogIn;
    private static ILogInModel mILogInModel;

    public LogInWrapper() {

    }

    public LogInWrapper(Context context) {
        super(context);
    }

    public void setLogInStraggle(ILogInModel inStraggle) {
        if (inStraggle != null)
            mILogInModel = inStraggle;
        else
            throw new NullPointerException("LogInStraggle is null");
    }

    /**
     * 可以手动修改也可以通过注解实现不同的登录方式的切换
     */
    public static void setLogInStyle(String inStyle) {
        if (mILogInModel == null) throw new NullPointerException("ILogInStraggle is null");

        mILogIn = mILogInModel.getLogInModelByName(inStyle);
        if (mILogIn == null) throw new NullPointerException("ILogIn object is null");
    }

    public static boolean isUserLogIn(){
        return mILogInModel.isUserLogIn();
    }

    @Override
    public void onLogIn() {
        if (isUserLogIn()) return;
        if (mILogIn == null) throw new NullPointerException("ILogIn is null ");
        mILogIn.onLogIn();
    }
}
