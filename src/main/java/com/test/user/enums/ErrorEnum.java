package com.test.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorEnum {
    USER_NOT_FOUND(1, "User %s not found")
    ;
    
    private int index;
    private String description;
}