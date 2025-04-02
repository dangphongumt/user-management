package com.test.user.controller;

import com.test.user.dto.request.LoginRequest;
import com.test.user.security.TokenProvider;
import com.test.user.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

//    private final AuthenticationService;
    private final TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
//        String token = JwtUtil.generateToken(loginRequest.getUserName());
        String token = tokenProvider.createToken(loginRequest.getUserName());
        return ResponseEntity.ok(token);
    }
}
