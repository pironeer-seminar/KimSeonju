package com.example.demo1.User.controller;

import com.example.demo1.User.dto.request.UserCreateReq;
import com.example.demo1.User.service.UserService;
import com.example.demo1.common.dto.ApiRes;
import com.example.demo1.common.type.UserSuccessType;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping("")
//    public Long create(@RequestBody UserCreateReq req) {
//        return userService.create(req);
//    }

    // Swagger 설명
    @Operation(summary = "유저 생성", description = "새로운 유저를 등록합니다.")
    @PostMapping("")
    public ApiRes<Long> create(@RequestBody @Valid UserCreateReq req) {
        System.out.println("🔥 요청된 이름: '" + req.getName() + "'");
        return ApiRes.success(UserSuccessType.CREATE, userService.create(req));
    }
}
