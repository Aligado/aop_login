package com.frame.fk.login;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogIn {
    public String userName() default "";

    public String phone() default "";

    public String userId() default "";

    //  fuck  0表示通过app的登录接口登录  1表示一键登录 2表示支付宝登录
    public String logInStyle() default LogInStyle.APP;
}
