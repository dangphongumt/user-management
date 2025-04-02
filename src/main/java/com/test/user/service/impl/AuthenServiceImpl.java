package com.test.user.service.impl;

import com.test.user.dto.request.LoginRequest;
import com.test.user.entity.User;
import com.test.user.enums.ErrorEnum;
import com.test.user.exception.ResourceNotFoundException;
import com.test.user.repository.UserRepository;
import com.test.user.service.AuthenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenServiceImpl implements AuthenService {
    private final UserRepository userRepository;
    @Override
    public void login(LoginRequest request) {
        User user = userRepository.findUserByUserName(request.getUserName())
                .orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.USER_NOT_FOUND));

    }
}
