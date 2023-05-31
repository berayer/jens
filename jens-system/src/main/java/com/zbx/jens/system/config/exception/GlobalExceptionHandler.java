package com.zbx.jens.system.config.exception;

import com.zbx.jens.core.response.Result;
import com.zbx.jens.core.response.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zbx
 * @date 2023/5/31
 * @description
 **/
@Slf4j
@RestControllerAdvice
@Configuration
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public Result<String> handlerException(AuthenticationException e) {
        log.info("身份验证异常: {}", e.getMessage());
        return Result.ofStatus(Status.FAILED, e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Result<String> handlerException(AccessDeniedException e) {
        log.info("拒绝访问异常: {}", e.getMessage());
        return Result.ofStatus(Status.FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> handlerException(Exception e) {
        System.out.println();
        log.warn("发生未处理异常: {}", e.getMessage());
        return Result.ofStatus(Status.ERROR, e.getMessage());
    }
}
