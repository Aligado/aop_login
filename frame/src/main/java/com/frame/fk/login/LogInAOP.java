package com.frame.fk.login;

import com.frame.fk.utils.Singleton;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 用户登录统一管理
 */
@Aspect
public class LogInAOP {
    private Singleton<ILogIn> mLogIn = new Singleton<ILogIn>() {
        @Override
        protected ILogIn create() {
            return new LogInWrapper();
        }
    };

    @Pointcut("execution(@com.frame.fk.login.LogIn * *(..))")
    public void checkLogIn() {

    }

    @Around("checkLogIn()")
    public void deal(ProceedingJoinPoint point) throws Throwable {
        if (LogInWrapper.isUserLogIn()) {
            point.proceed();
        } else {
            MethodSignature methodSignature = (MethodSignature) point.getSignature();
            LogIn logIn = methodSignature.getMethod().getAnnotation(LogIn.class);
            String style = logIn.logInStyle();
            LogInWrapper.setLogInStyle(style);
            mLogIn.get().onLogIn();
        }
    }
}
