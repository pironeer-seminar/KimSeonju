package com.example.pironeer4.repository;

import com.example.pironeer4.entity.Comment;
import com.example.pironeer4.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 특정 게시물에 달린 댓글 모두 조회
    List<Comment> findAllByPost(Post post);
}
