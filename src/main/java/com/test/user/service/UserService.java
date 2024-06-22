package com.test.user.service;

import com.test.user.dto.request.UserRequest;
import com.test.user.entity.UserEntity;

public interface UserService {
    public String getAll();
    public UserEntity createUser(UserRequest userRequest);
}
