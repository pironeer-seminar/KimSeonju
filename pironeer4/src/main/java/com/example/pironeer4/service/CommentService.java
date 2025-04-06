package com.example.pironeer4.service;

import com.example.pironeer4.dto.request.CommentReq;
import com.example.pironeer4.dto.response.CommentRes;
import com.example.pironeer4.entity.Comment;
import com.example.pironeer4.entity.Post;
import com.example.pironeer4.entity.User;
import com.example.pironeer4.repository.CommentRepository;
import com.example.pironeer4.repository.PostRepository;
import com.example.pironeer4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Long create(CommentReq req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("조회된 유저가 없습니다."));

        Post post = postRepository.findById(req.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("조회된 게시물이 없습니다"));

        Comment comment = Comment.create(user, post, req.getContent());
        comment = commentRepository.save(comment);
        return comment.getId();

    }

    // 특정 게시물의 모든 댓글을 조회
    public List<CommentRes> findByPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        return commentRepository.findAllByPost(post).stream()  // 해당 댓글들을 다 찾아준 -> [comment1, comment2, comment3]
                .map(comment -> new CommentRes(
                        comment.getId(),             // CommentRes 생성자의 순서와 맞게 넘겨야함
                        comment.getUser().getId(),
                        comment.getPost().getId(),
                        comment.getContent(),
                        comment.getCreatedAt()
                ))
                .toList();
    }

}
