package com.example.demo1.common.exception;

import com.example.demo1.common.dto.ApiRes;
import com.example.demo1.common.type.CommonErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    // BaseException
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiRes<?>> handleCustomException(BaseException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ApiRes.fail(ex), ex.getHttpStatus());
    }

    //MethodArgumentNotValidException : 요청 객체(DTO)의 필드가 검증 조건을 만족하지 못하면 발생하는 예외 클래스
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiRes<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // 유효성 검사 실패 메시지를 꺼내서 문자열로 만들기(첫 번쨰 에러 메시지를 꺼냄)
        // ex.getBindingResult().getFieldErrors() : 유효성 검사 실패한 필드 에러 목록(List)
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ":" + error.getDefaultMessage()) //각 에러 객체를 문자열로 변환
                .findFirst()  // 여러 개의 에러 중에서 첫 번째 하나만 선택
                .orElse("유효성 검사 실패");   // 만약 에러가 없으면 기본 메시지를 사용

        return new ResponseEntity<>(
                ApiRes.fail(CommonErrorType.INVALID_REQUEST, HttpStatus.BAD_REQUEST, errorMessage),
                HttpStatus.BAD_REQUEST
        );


    }

}
