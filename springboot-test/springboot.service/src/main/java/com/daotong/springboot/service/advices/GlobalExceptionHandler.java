package com.daotong.springboot.service.advices;

import com.daotong.springboot.service.base.RestResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zdh 2019/12/9 9:21
 */
//@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public RestResponse handleException(RuntimeException ex){
        return RestResponse.error("400",ex.getMessage());
    }
}