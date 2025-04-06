package com.example.pironeer4.dto.request;

import com.example.pironeer4.entity.PostStatus;
import lombok.Getter;

@Getter
public class PostCreateReq {

    private Long userId;

    private String title;

    private String content;

    private PostStatus status;
}