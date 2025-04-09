package com.example.demo1.Post.controller;

import com.example.demo1.Post.dto.request.PostCreateReq;
import com.example.demo1.Post.dto.request.PostUpdateReq;
import com.example.demo1.Post.dto.response.PostSearchRes;
import com.example.demo1.Post.service.PostService;
import com.example.demo1.common.dto.ApiRes;
import com.example.demo1.common.type.PostSuccessType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 생성
    @PostMapping("")
    public Long create(@RequestBody PostCreateReq req) {
        return postService.create(req);
    }

    // 목록조회
    // ApiRes
    @GetMapping("")
    public ApiRes<List<PostSearchRes>> search() {
        return ApiRes.success(PostSuccessType.GET_ALL, postService.search());
    }
    // 단일조회
    @GetMapping("/{postId}")
    public PostSearchRes detail(
            @PathVariable("postId") Long postId
    ) {
        return postService.detail(postId);
    }

    // 수정
    @PutMapping("/{postId}")
    public Long update(
            @PathVariable("postId") Long postId,
            @RequestBody PostUpdateReq req) {
        return postService.update(postId, req);
    }

    // 삭제
    @DeleteMapping("/{postId}")
    public Long delete(
            @PathVariable("postId") Long postId
    ) {
        return postService.delete(postId);
    }
}
