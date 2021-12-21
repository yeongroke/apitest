package com.yrkim.apitest.exception;

import com.yrkim.apitest.handler.ResponseCode;

public class ApiNullException extends NullPointerException {
    private ResponseCode errorCode;

    public ApiNullException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ResponseCode getErrorCode() {
        return errorCode;
    }
}
