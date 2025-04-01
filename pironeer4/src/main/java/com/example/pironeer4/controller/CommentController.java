package com.example.pironeer4.controller;


import com.example.pironeer4.dto.request.CommentReq;
import com.example.pironeer4.dto.response.CommentRes;
import com.example.pironeer4.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 등록
    @PostMapping("")
    public Long create(@RequestBody CommentReq req) {
        return commentService.create(req);
    }

    //게시물에 달린 댓글 조회
    //@PathVariable("postId") Long postId : URL 경로에서 받은 {postId}값을 자바 메서드의 postId 변수로 전달해줌
    @GetMapping("/post/{postId}")
    public List<CommentRes> getCommentByPost(@PathVariable("postId") Long postId) {
        return commentService.findByPost(postId);
    }
}
