package com.example.demo1.Post.dto.request;

import com.example.demo1.Post.entity.PostStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostUpdateReq {

    @Schema(description = "수정할 게시물 제목", example = "제목 변경합니다.")
    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @Schema(description = "수정할 게시물 내용", example = "내용도 함께 수정해요.")
    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    @Schema(description = "게시물 상태 (공개 여부)", example = "PRIVATE")
    @NotNull(message = "게시물 상태는 필수입니다.")
    private PostStatus status;
}
