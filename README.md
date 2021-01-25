# aop_login
# 简介

这是一个android的基于AOP方式来实现用户登录的框架
这是一个基于AOP方式，实现

# 使用方法

## **0、封装登录模块，所有的登录模块需要implement ILogIn接口

eg第三方支付宝登录
```
public class ALogIn extends Model implements ILogIn {
    public ALogIn(Context context) {
        super(context);
    }

    @Override
    public void onLogIn() {
        Toast.makeText(mAppContext, "通过支付宝第三方登录", Toast.LENGTH_LONG).show();
    }
}
```

## **1、 实现UserLogIn类
```
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
```

## **2、在Application中实现
```
public void onCreate() {
 LogInWrapper logInWrapper = new LogInWrapper(getApplicationContext());
        // 默认使用app登录
        UserLogInSub gen = new UserLogInSub(getApplicationContext(), null);
        logInWrapper.setLogInStraggle(gen);
}
```

## **3、登录逻辑实现
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogInWrapper logInWrapper = new LogInWrapper(getApplicationContext());
        // 默认使用app登录
        UserLogInSub gen = new UserLogInSub(getApplicationContext(), null);
        logInWrapper.setLogInStraggle(gen);

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAppLogIn();
            }
        });
    }

    @LogIn(logInStyle = LogInStyle.APP)
    public void onAppLogIn() {
        Intent intent = new Intent(MainActivity.this, ShoppingActivity.class);
        startActivity(intent);
    }
}
```
