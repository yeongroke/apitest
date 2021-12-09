package com.yrkim.apitest.handler;

import com.yrkim.apitest.exception.ApiException;
import com.yrkim.apitest.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    // 선언된 Exception이 발생하면 해당 Handler 실행
    @ExceptionHandler(Exception.class)
    // HttpStatus.INTERNAL_SERVER_ERROR에 해당하는 Exception이 발생하면 Response에 출력되는 HttpStatus Code 출력
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<ErrorResponse> httpRequestMethodNotExceptionHandler(Exception e){
        final ErrorResponse errorResponse = ErrorResponse.create()
                .code("500")
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .message(e.getMessage());

        return new ResponseEntity<>(errorResponse , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //@Valid 검증 실패 시 Catch
    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<ErrorResponse> invalidParameterExceptionHandler(ApiException e) {
        ResponseCode errorCode = e.getErrorCode();
        ErrorResponse response = getErrorResponse(errorCode , e);
        return new ResponseEntity<>(response, HttpStatus.resolve(errorCode.getStatus()));
    }

    //CustomException을 상속받은 클래스가 예외를 발생 시킬 시, Catch하여 ErrorResponse를 반환한다.
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> customExceptionHandler(CustomException e) {
        ResponseCode errorCode = e.getErrorCode();
        ErrorResponse response = getErrorResponse(errorCode , e);
        return new ResponseEntity<>(response, HttpStatus.resolve(errorCode.getStatus()));
    }

    private ErrorResponse getErrorResponse(ResponseCode errorCode , Exception e) {
        return ErrorResponse
                .create()
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .message(e.toString());
    }
}
