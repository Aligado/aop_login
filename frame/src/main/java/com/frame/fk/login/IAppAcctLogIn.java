package com.frame.fk.login;

/**
 * app账号登录的接口
 */
public interface IAppAcctLogIn {
    /**
     * @param c 登录页面Activity
     * @param defaultUserAcct 登录账号
     */
    public void onAppLogIn(Class c, String defaultUserAcct);
}
