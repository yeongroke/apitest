package com.yrkim.apitest.handler;

public enum ResponseCode {
    INVALID_PARAMETER(400, null, "Invalid Request Data"),
    API_PARAMETER_NULL(500, "500", "INPUT API PARAMETER"),
    EXPIRATION(410, "410", "It Was Expired"),
    NOT_FOUND(404, "404", "Not Found"),
    SERVER_ERROR(500,"500","SERVER ERROR"),
    SUCCESS(200, "500" , "Success");

    private final String code;
    private final String message;
    private final int status;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    ResponseCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}

