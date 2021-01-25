package com.frame.fk.login;

/**
 * 获取具体的登录模块
 * 判断登录状态
 */
public interface ILogInModel {
    public ILogIn getLogInModelByName(String style);
    public boolean isUserLogIn();
}
