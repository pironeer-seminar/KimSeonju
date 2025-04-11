package com.example.demo1.User.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class UserCreateReq {

    @Schema(description = "유저 이름", example = "홍길동")
    private String name;
}
