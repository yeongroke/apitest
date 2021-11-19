package com.yrkim.apitest.exception;

import com.yrkim.apitest.handler.ErrorCode;
import org.springframework.validation.Errors;

public class ApiException extends CustomException {

    private final Errors errors;

    public ApiException(Errors errors) {
        super(ErrorCode.INVALID_PARAMETER);
        this.errors = errors;
    }

    public Errors getErrors() {
        return this.errors;
    }
}
