package com.test.user.controller;


import com.test.user.dto.request.UserRequest;
import com.test.user.dto.response.UserResponse;
import com.test.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @PutMapping("/{userId}")
    public UserResponse updateUserById(@RequestParam UUID userId, @RequestBody UserRequest request) {
        return userService.updateUser(userId, request);
    }
}
