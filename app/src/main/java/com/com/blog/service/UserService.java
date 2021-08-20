package com.com.blog.service;

import com.com.blog.controller.dto.CMRespDto;
import com.com.blog.controller.dto.JoinDto;
import com.com.blog.controller.dto.LoginDto;
import com.com.blog.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("/login")
    Call<CMRespDto<User>> login(@Body LoginDto loginDto);

    @POST("/join")
    Call<CMRespDto<User>> join(@Body JoinDto joinDto);

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.100.202.35:8080")
            .build();

    UserService service = retrofit.create(UserService.class);



}
