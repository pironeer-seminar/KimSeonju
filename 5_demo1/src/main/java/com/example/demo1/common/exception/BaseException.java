package com.example.demo1.common.exception;


import com.example.demo1.common.type.ErrorType;
import org.springframework.http.HttpStatus;

// 런타임 예외를 상속받음 (Spring에서는 거의 대부분 RuntimeException 씀)
public class BaseException extends RuntimeException {

    private final ErrorType errorType;
    private final HttpStatus httpStatus;

    public BaseException(ErrorType errorType, HttpStatus httpStatus) {
        super(errorType.getMessage()); // 부모 클래스인 RuntimeException 메시지를 전달
        this.errorType = errorType;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public int getHttpCode() {
        return this.httpStatus.value();  // // int로 500, 400 등 추출
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }
}
