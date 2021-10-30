package com.tpirates.apitest.exception;

import com.tpirates.apitest.handler.ErrorCode;
import java.io.Serializable;

public class CustomException extends RuntimeException implements Serializable {

    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
