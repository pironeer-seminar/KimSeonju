package com.example.pironeer4.repository;

import com.example.pironeer4.entity.Post;
import com.example.pironeer4.entity.PostStatus;
import com.example.pironeer4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByStatus(PostStatus status);  // SELECT * FROM post WHERE status = ?;

    List<Post> findAllByUser(User user); // 특정 유저가 작성한 모든 게시글 조회
}
