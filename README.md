# aop_login
# 简介

这是一个android的基于AOP方式来实现用户登录的框架
这是一个基于AOP方式，实现

# 使用方法

1、 集成UserLogIn，实现getLogInModelByName方法
###
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
###
