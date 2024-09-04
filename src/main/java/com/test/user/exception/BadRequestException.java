package com.test.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class BadRequestException extends RuntimeException {
    private String code;
    private String description;
    private Object data;

    public BadRequestException(String code, String description, Object data) {
        super(description);
        this.code = code;
        this.description = description;
        this.data = data;
    }
    public BadRequestException(Object data) {
        this.data = data;
    }
}
