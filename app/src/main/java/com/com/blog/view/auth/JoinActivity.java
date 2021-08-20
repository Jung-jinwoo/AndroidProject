package com.com.blog.view.auth;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.com.blog.R;
import com.com.blog.config.SessionUser;
import com.com.blog.controller.AuthController;
import com.com.blog.controller.dto.CMRespDto;
import com.com.blog.controller.dto.JoinDto;
import com.com.blog.controller.dto.LoginDto;
import com.com.blog.model.User;
import com.com.blog.view.InitActivity;
import com.com.blog.view.post.PostListActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class JoinActivity extends AppCompatActivity implements InitActivity {

    private static final String TAG = "JoinActivity";
    private JoinActivity mContext = JoinActivity.this;

    private TextInputEditText tvUsername, tvPassword, tvEmail;
    private MaterialButton btnJoin;
    private TextView tvLinkLogin;

    private AuthController authController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        init();
        initLr();
        initSetting();
    }

    @Override
    public void init() {
        authController = new AuthController();
        tvUsername = findViewById(R.id.tvUsername);
        tvPassword = findViewById(R.id.tvPassword);
        tvEmail = findViewById(R.id.tvEmail);
        btnJoin = findViewById(R.id.btnJoin);
        tvLinkLogin = findViewById(R.id.tvLinkLogin);
    }

    @Override
    public void initLr() {
        btnJoin.setOnClickListener(v -> {
            String username = tvUsername.getText().toString().trim();
            String password = tvPassword.getText().toString().trim();
            String email = tvEmail.getText().toString().trim();
            authController.join(new JoinDto(username, password, email)).enqueue(new Callback<CMRespDto<User>>() {
                @Override
                public void onResponse(Call<CMRespDto<User>> call, Response<CMRespDto<User>> response) {
                    CMRespDto<User> cm =  response.body();
                    Headers headers = response.headers();
//                    Log.d(TAG, "onResponse: "+cm.getCode());
//                    Log.d(TAG, "onResponse: "+cm.getData().getUsername());
//                    Log.d(TAG, "onResponse: 토큰 : "+headers.get("Authorization"));
                    SessionUser.user = cm.getData();
                    SessionUser.token = headers.get("Authorization");

                    Log.d(TAG, "onResponse: 세션 : "+SessionUser.token);
                    Intent intent = new Intent(
                            mContext,
                            PostListActivity.class
                    );
                    // Login -> List
                    // List
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<CMRespDto<User>> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });

        tvLinkLogin.setOnClickListener((v)->{
            Intent intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void initSetting() {

    }
}