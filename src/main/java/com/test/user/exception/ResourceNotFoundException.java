package com.test.user.exception;

import com.test.user.enums.ErrorEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {
    private String code;
    private String description;
    private Object data;

    public ResourceNotFoundException(String code, String description, Object data) {
        super(description);
        this.code = code;
        this.description = description;
        this.data = data;
    }
    
    public ResourceNotFoundException(String code) {
        this.code = code;
    }
    
    public ResourceNotFoundException(ErrorEnum errorEnum) {
        this.code = errorEnum.name();
        this.description = errorEnum.getDescription();
    }
}
