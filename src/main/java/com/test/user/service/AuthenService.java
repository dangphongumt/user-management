package com.test.user.service;

import com.test.user.dto.request.LoginRequest;

public interface AuthenService {
    public void login(LoginRequest request);
}
