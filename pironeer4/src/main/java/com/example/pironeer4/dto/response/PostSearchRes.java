package com.example.pironeer4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor  // 모든 필드를 한번에 받는 생성자 생성
public class PostSearchRes {

    private Long userId;
    private Long postId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
