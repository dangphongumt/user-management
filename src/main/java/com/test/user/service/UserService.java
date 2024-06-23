package com.test.user.service;

import com.test.user.dto.request.UserRequest;
import com.test.user.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponse> getUsers();
    UserResponse createUser(UserRequest request);
    UserResponse updateUser(UUID userId, UserRequest request);
}
