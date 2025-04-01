package com.example.pironeer4.controller;


import com.example.pironeer4.dto.request.UserCreateReq;
import com.example.pironeer4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public Long create(@RequestBody UserCreateReq req) {
        return userService.create(req);
    }

}
