package com.frame.fk;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.frame.fk.login.LogIn;
import com.frame.fk.login.LogInWrapper;
import com.frame.fk.login.LogInStyle;

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