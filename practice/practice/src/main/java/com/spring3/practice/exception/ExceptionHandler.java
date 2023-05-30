package com.spring3.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ProblemDetail idNotFound(RuntimeException ex){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,"Employee with id not found");
    }
}
