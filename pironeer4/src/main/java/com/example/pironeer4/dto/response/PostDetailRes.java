package com.example.pironeer4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostDetailRes {
    private Long postId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentRes> comments;  // 댓글 리스트 포함
}
