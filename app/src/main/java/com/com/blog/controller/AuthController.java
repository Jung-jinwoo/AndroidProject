package com.com.blog.controller;

import com.com.blog.controller.dto.CMRespDto;
import com.com.blog.controller.dto.LoginDto;
import com.com.blog.model.User;
import com.com.blog.service.PostService;
import com.com.blog.service.UserService;

import retrofit2.Call;

public class AuthController {
    private static final String TAG = "AuthController";
    private UserService userService = UserService.service;

    public Call<CMRespDto<User>> login(LoginDto loginDto){
        return userService.login(loginDto);
    }
}
