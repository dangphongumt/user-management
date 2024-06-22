package com.test.user.service.impl;

import com.test.user.dto.request.UserRequest;
import com.test.user.entity.UserEntity;
import com.test.user.repository.UserRepository;
import com.test.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public String getAll() {
        return null;
    }

    @Override
    public UserEntity createUser(UserRequest userRequest) {
        UserEntity user = new UserEntity();
        user.setUserName(userRequest.getUserName());
        user.setFullName(userRequest.getFullName());
        return userRepository.save(user);
    }
}
