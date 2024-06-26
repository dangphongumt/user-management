package com.test.user.service.impl;

import com.test.user.dto.request.UserRequest;
import com.test.user.dto.response.UserResponse;
import com.test.user.entity.User;
import com.test.user.enums.ErrorEnum;
import com.test.user.exception.ResourceNotFoundException;
import com.test.user.repository.UserRepository;
import com.test.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getUsers() {
        List<User> userEntities = userRepository.findAll();
        return userEntities.stream().map(UserResponse::new).toList();
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setFullName(request.getFullName());
        return new UserResponse(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserResponse updateUser(UUID userId, UserRequest request) {
        User user = this.findUserById(userId);
        
        System.out.println(user.toString());
        
        BeanUtils.copyProperties(request, user);//refer Jackson mapper for case complex
        
        System.out.println(user.toString());
        
        return new UserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getUserById(UUID userId) {
        User user = this.findUserById(userId);
        return new UserResponse(user);
    }

    private User findUserById(UUID id) {
        return userRepository.findUserById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.USER_NOT_FOUND));
    }
}
