package com.example.demo1.Post.dto.request;

import com.example.demo1.Post.entity.PostStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class PostCreateReq {

    @Schema(description = "게시물 작성자의 ID", example = "1")
    private Long userId;

    @Schema(description = "게시물 제목", example = "오늘의 날씨")
    private String title;

    @Schema(description = "게시물 내용", example = "완전 봄날씨이다.")
    private String content;

    @Schema(description = "게시물 상태(공개여부)", example = "PUBLIC")
    private PostStatus status;
}
