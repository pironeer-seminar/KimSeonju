package com.example.demo1.Post.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostSearchRes {

    @Schema(description = "작성한 사용자 ID", example = "1")
    private Long userId;

    @Schema(description = "게시물 ID", example = "10")
    private Long postId;

    @Schema(description = "게시물 제목", example = "오늘의 기분")
    private String title;

    @Schema(description = "게시물 내용", example = "오늘은 행복했어요.")
    private String content;

    @Schema(description = "게시물 생성 시각", example = "2025-04-11T15:32:17")
    private LocalDateTime createdAt;
}
