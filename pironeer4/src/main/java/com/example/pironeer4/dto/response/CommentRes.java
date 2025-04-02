package com.example.pironeer4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentRes {
    private Long id;
    private Long userId;
    private Long postId;
    private String content;
    private LocalDateTime createdAt;
}
