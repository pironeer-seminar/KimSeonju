package com.example.demo1.Post.dto.request;

import com.example.demo1.Post.entity.PostStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class PostUpdateReq {

    @Schema(description = "수정할 게시물 제목", example = "제목 변경합니다.")
    private String title;

    @Schema(description = "수정할 게시물 내용", example = "내용도 함께 수정해요.")
    private String content;

    @Schema(description = "게시물 상태 (공개 여부)", example = "PRIVATE")
    private PostStatus status;
}
