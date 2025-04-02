package com.example.pironeer4.controller;


import com.example.pironeer4.dto.request.UserCreateReq;
import com.example.pironeer4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 클라이언트에게 JSON 응답을 반환하는 컨트롤러
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public Long create(@RequestBody UserCreateReq req) { // @RequestBody UserCreateReq req : 요청 JSON -> DTO 객체로 매핑
        return userService.create(req);
    }

}
