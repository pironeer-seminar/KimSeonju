package com.example.pironeer4.controller;

import com.example.pironeer4.dto.request.PostCreateReq;
import com.example.pironeer4.dto.request.PostUpdateReq;
import com.example.pironeer4.dto.response.PostDetailRes;
import com.example.pironeer4.dto.response.PostSearchRes;
import com.example.pironeer4.entity.Post;
import com.example.pironeer4.entity.User;
import com.example.pironeer4.service.PostService;
import com.example.pironeer4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    // 생성
    @PostMapping("")
    public Long create(@RequestBody PostCreateReq req) {
        return postService.create(req);
    }

    // 목록조회
    @GetMapping("")
    public List<PostSearchRes> search() {
        return postService.search();
    }

    // 단일조회
    @GetMapping("/{postId}")
    public PostDetailRes detail(
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

    //특정 유저가 작성한 모든 게시글 조회
    @GetMapping("/users/{userId}/posts")
    public List<Post> getPostsByUser(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return postService.findAllByUser(user);
    }
}