package com.example.demo1.Post.controller;

import com.example.demo1.Post.dto.request.PostCreateReq;
import com.example.demo1.Post.dto.request.PostUpdateReq;
import com.example.demo1.Post.dto.response.PostSearchRes;
import com.example.demo1.Post.service.PostService;
import com.example.demo1.common.dto.ApiRes;
import com.example.demo1.common.type.PostSuccessType;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 생성
//    @PostMapping("")
//    public Long create(@RequestBody PostCreateReq req) {
//        return postService.create(req);
//    }
    @Operation(summary = "게시물 생성", description = "새 게시물을 작성합니다.")
    @PostMapping("")
    public ApiRes<Long> create(@RequestBody @Valid PostCreateReq req) {
        Long id = postService.create(req);
        return ApiRes.success(PostSuccessType.CREATE, id);
    }

    // 목록조회
    // ApiRes
    @Operation(summary = "게시물 목록 조회", description = "모든 게시물을 조회합니다.")
    @GetMapping("")
    public ApiRes<List<PostSearchRes>> search() {
        return ApiRes.success(PostSuccessType.GET_ALL, postService.search());
    }

    // 단일조회
//    @GetMapping("/{postId}")
//    public PostSearchRes detail(@PathVariable("postId") Long postId) {
//        return postService.detail(postId);
//    }
    @Operation(summary = "게시물 단일 조회", description = "특정 ID의 게시물을 조회합니다.")
    @GetMapping("/{postId}")
    public ApiRes<PostSearchRes> detail(@PathVariable("postId") Long postId) {
        return ApiRes.success(PostSuccessType.GET_ONE, postService.detail(postId));
    }

    // 수정
//    @PutMapping("/{postId}")
//    public Long update(
//            @PathVariable("postId") Long postId,
//            @RequestBody PostUpdateReq req) {
//        return postService.update(postId, req);
//    }
    @Operation(summary = "게시물 수정", description = "특정 게시물을 수정합니다.")
    @PutMapping("/{postId}")
    public ApiRes<Long> update(@PathVariable("postId") Long postId, @RequestBody @Valid PostUpdateReq req) {
        Long id = postService.update(postId, req);
        return ApiRes.success(PostSuccessType.UPDATE, id);
    }

    // 삭제
//    @DeleteMapping("/{postId}")
//    public Long delete(@PathVariable("postId") Long postId) {
//        return postService.delete(postId);
//    }
    @Operation(summary = "게시물 삭제", description = "특정 게시물을 삭제합니다.")
    @DeleteMapping("/{postId}")
    public ApiRes<Long> delete(@PathVariable("postId") Long postId) {
        return ApiRes.success(PostSuccessType.DELETE, postService.delete(postId));
    }
}
