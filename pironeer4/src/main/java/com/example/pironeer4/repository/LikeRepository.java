package com.example.pironeer4.repository;

import com.example.pironeer4.entity.Like;
import com.example.pironeer4.entity.Post;
import com.example.pironeer4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    // "이 유저가 이 글에 좋아요 한 적 있는지?"
    // SELECT EXISTS(
    //  SELECT 1 FROM likes WHERE user_id = ? AND post_id = ?
    //);
    boolean existsByUserAndPost(User user, Post post);

    // 좋아요 해제(삭제)
    // DELETE FROM likes WHERE user_id = ? AND post_id = ?;
    void deleteByUserAndPost(User user, Post post);

    // 좋아요 수
    // SELECT COUNT(*) FROM likes WHERE post_id = ?;
    int countByPost(Post post);
}
