package com.frame.fk.login;


/**
 * 用户登录状态
 */
public enum UserStatus {
    // 未登录，登录，不存在，token失效
    USER_NOT_LOGIN, USER_LOGIN, USER_NOT_EXIST, USER_TOKEN_INVALID
}
