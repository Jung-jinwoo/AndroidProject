package com.com.blog.view.user;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.com.blog.R;
import com.com.blog.view.CustomAppBarActivity;
import com.com.blog.view.InitActivity;

public class UserInfoActivity extends CustomAppBarActivity implements InitActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        init();
        initLr();
        initSetting();
    }

    @Override
    public void init() {

    }

    @Override
    public void initLr() {

    }

    @Override
    public void initSetting() {
        onAppBarSettings(true, "UserInfo");
    }
}