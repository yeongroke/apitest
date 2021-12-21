package com.yrkim.apitest.handler;

import com.yrkim.apitest.exception.ApiException;
import com.yrkim.apitest.exception.ApiNullException;
import com.yrkim.apitest.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerExceptionHandler {

    // 선언된 Exception이 발생하면 해당 Handler 실행
    @ExceptionHandler(Exception.class)
    // HttpStatus.INTERNAL_SERVER_ERROR에 해당하는 Exception이 발생하면 Response에 출력되는 HttpStatus Code 출력
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<ErrorResponse> httpRequestMethodNotExceptionHandler(Exception e){
        final ErrorResponse errorResponse = ErrorResponse.create()
                .code("500")
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .message("Server Error");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorResponse);
    }

    //@Valid 검증 실패 시 Catch
    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<ErrorResponse> invalidParameterExceptionHandler(ApiException e) {
        ResponseCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = getErrorResponse(errorCode , e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorResponse);
    }

    //@Valid 검증 실패 시 Catch
    @ExceptionHandler(ApiNullException.class)
    protected ResponseEntity<ErrorResponse> apiNullExceptionHandler(ApiException e) {
        ResponseCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = getErrorResponse(errorCode , e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorResponse);
    }

    //@Valid 검증 실패 시 Catch
    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ErrorResponse> NullExceptionHandler(ApiException e) {
        ResponseCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = getErrorResponse(errorCode , e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorResponse);
    }

    //CustomException을 상속받은 클래스가 예외를 발생 시킬 시, Catch하여 ErrorResponse를 반환한다.
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> customExceptionHandler(CustomException e) {
        ResponseCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = getErrorResponse(errorCode , e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorResponse);
    }

    private ErrorResponse getErrorResponse(ResponseCode errorCode , Exception e) {
        log.info("getErrorResponse: ");
        return ErrorResponse
                .create()
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .message("Error Boom");
    }
}
