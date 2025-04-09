package com.example.demo1.common.exception;

import com.example.demo1.common.dto.ApiRes;
import com.example.demo1.common.type.CommonErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j // 로깅을 위한 것, 더 깔끔하게
@RestControllerAdvice // 모든 controller 대해 전역적으로 예외 처리 가능
public class GlobalExceptionHandler {

    // ResponseEntity<ApiRes<?>> : 리턴 형식
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiRes<?>> handleIllegalArgumentException(final IllegalArgumentException ex) {
        log.error(ex.getMessage()); // 로그 출력, ex.getMessage = "조회된 유저가 없습니다.”

        return new ResponseEntity<>(
                ApiRes.fail(CommonErrorType.INTERNAL_SERVER, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
