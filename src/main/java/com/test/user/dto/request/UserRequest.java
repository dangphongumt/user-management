package com.test.user.dto.request;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserRequest {
    private String userName;
    private String fullName;
    private String phoneNumber;
}
