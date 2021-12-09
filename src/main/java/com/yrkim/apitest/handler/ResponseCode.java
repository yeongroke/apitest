package com.yrkim.apitest.handler;

public enum ResponseCode {
    INVALID_PARAMETER(400, null, "Invalid Request Data"),
    EXPIRATION(410, "410", "It Was Expired"),
    NOT_FOUND(404, "404", "Not Found"),
    GIS_ERROR(500,"500","GIS ERROR"),
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

