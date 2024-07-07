package com.test.user.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class LoginRequest {
    @NotNull
    private String userName;
    @NotNull
    private String password;
}
