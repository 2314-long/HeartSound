package com.heartsound.common.exception;

import com.heartsound.common.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public R<?> authExceptionHandler(XzAbstractException exception) {
        return R.fault(exception.getCode(), exception.getMessage());
    }
}
