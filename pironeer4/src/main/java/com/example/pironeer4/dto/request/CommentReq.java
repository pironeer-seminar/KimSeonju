package com.example.pironeer4.dto.request;

import lombok.Getter;

@Getter
public class CommentReq {
    private Long userId;  // 누가
    private Long postId;  // 어떤 게시글에
    private String content; // 어떤 내용으로
}
