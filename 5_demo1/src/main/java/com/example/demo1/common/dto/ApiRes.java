package com.example.demo1.common.dto;

import com.example.demo1.common.type.SuccessType;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

// 모든 API 응답의 기본 틀을 제공
// <T> : 감싸고 있는, 모든 것을 받을 수 있는
// T : 응답이 있을수도 있고, 없을수도 (ex> delete)
public record ApiRes<T> (
        Integer status, String code, String message, @JsonInclude(JsonInclude.Include.NON_NULL) T data) {

    // 응답이 없는 버전 -> null
    public static ApiRes<?> success(SuccessType successType) {
        return new ApiRes<>(HttpStatus.OK.value(), successType.getCode(), successType.getMessage(), null);
    }

    // 응답이 있는 버전 -> data
    public static <T> ApiRes<T> success(SuccessType successType, T data) {
        return new ApiRes<>(HttpStatus.OK.value(), successType.getCode(), successType.getMessage(), data);
    }
}

