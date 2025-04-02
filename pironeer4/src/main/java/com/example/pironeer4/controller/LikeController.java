package com.example.pironeer4.controller;

import com.example.pironeer4.entity.Post;
import com.example.pironeer4.entity.User;
import com.example.pironeer4.service.LikeService;
import com.example.pironeer4.service.PostService;
import com.example.pironeer4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes/")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;
    private final UserService userService;
    private final PostService postService;

    // 좋아요 생성
    @PostMapping("/{postId}/users/{userId}")
    public void like(@PathVariable Long postId, @PathVariable Long userId) {
        User user = userService.findById(userId);
        Post post = postService.findById(postId);
        likeService.likePost(user, post);
    }

    // 좋아요 취소
    @DeleteMapping("/{postId}/users/{userId}")
    public void unlike(@PathVariable Long postId, @PathVariable Long userId) {
        User user = userService.findById(userId);
        Post post = postService.findById(postId);
        likeService.unlikePost(user, post);
    }

    // 좋아요 수 조회
    @GetMapping("/{postId}/count")
    public int count(@PathVariable Long postId) {
        Post post = postService.findById(postId);
        return likeService.countLikes(post);
    }
}

