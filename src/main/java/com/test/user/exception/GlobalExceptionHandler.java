package com.test.user.exception;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
@Slf4j
//@Order(-100)
public class GlobalExceptionHandler {
    private static final String CODE = "code";
    private static final String DESCRIPTION = "description";

//    @Autowired
//    private Tracer tracer;

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = { AuthenticationException.class, HttpClientErrorException.Unauthorized.class })
//    public ProblemDetail unauthorizedException(AuthenticationException ex) {
//        ProblemDetailExt problemDetailExt = ProblemDetailExt
//                .forStatusAndDetailAndTracer(HttpStatus.UNAUTHORIZED, ex.getLocalizedMessage(), tracer);
//        return problemDetailExt;
//    }
    
    @ExceptionHandler(value = BadRequestException.class)
    public ProblemDetail badRequestException(BadRequestException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        Map<String, Object> properties = new HashMap<>();
        properties.put(CODE, ex.getCode());
        properties.put(DESCRIPTION, ex.getDescription());

        problemDetail.setProperties(properties);
        return problemDetail;
    }
    
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ProblemDetail resourceNotFoundException(ResourceNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        Map<String, Object> properties = new HashMap<>();
        properties.put(CODE, ex.getCode());
        properties.put(DESCRIPTION, ex.getDescription());

        problemDetail.setProperties(properties);
        return problemDetail;
    }
}
