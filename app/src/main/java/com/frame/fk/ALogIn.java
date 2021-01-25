package com.frame.fk;

import android.content.Context;
import android.widget.Toast;

import com.frame.fk.frame.Model;
import com.frame.fk.login.ILogIn;

public class ALogIn extends Model implements ILogIn {
    public ALogIn(Context context) {
        super(context);
    }

    @Override
    public void onLogIn() {
        Toast.makeText(mAppContext, "通过支付宝第三方登录", Toast.LENGTH_LONG).show();
    }
}
