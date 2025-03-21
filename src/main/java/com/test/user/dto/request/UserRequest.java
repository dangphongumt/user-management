package com.test.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserRequest {

    @NotBlank
    private String userName;
    private String fullName;
    private String phoneNumber;
}
