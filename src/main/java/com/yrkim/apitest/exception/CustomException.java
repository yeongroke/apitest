package com.yrkim.apitest.exception;

import com.yrkim.apitest.handler.ResponseCode;
import java.io.Serializable;

public class CustomException extends RuntimeException implements Serializable {

    private ResponseCode errorCode;

    public CustomException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ResponseCode getErrorCode() {
        return errorCode;
    }
}
