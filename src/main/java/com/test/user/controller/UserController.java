package com.test.user.controller;


import com.test.user.dto.request.UserRequest;
import com.test.user.entity.UserEntity;
import com.test.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getAll(){
        return "A";
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }
}
