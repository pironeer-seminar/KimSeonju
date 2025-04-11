package com.example.demo1.Post.dto.request;

import com.example.demo1.Post.entity.PostStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostCreateReq {

    @Schema(description = "게시물 작성자의 ID", example = "1")
    @NotNull(message = "작성자 ID는 필수입니다.")
    private Long userId;

    @Schema(description = "게시물 제목", example = "오늘의 날씨")
    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @Schema(description = "게시물 내용", example = "완전 봄날씨이다.")
    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    @Schema(description = "게시물 상태(공개여부)", example = "PUBLIC")
    @NotNull(message = "게시물 상태는 필수입니다.") // enum 타입 -> NOTNULL
    private PostStatus status;
}
