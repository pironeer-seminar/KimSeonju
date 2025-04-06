package com.example.pironeer4.service;

import com.example.pironeer4.entity.Like;
import com.example.pironeer4.entity.Post;
import com.example.pironeer4.entity.User;
import com.example.pironeer4.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class LikeService {

    private final LikeRepository likeRepository;

    // 좋아요 생성
    @Transactional
    public void likePost(User user, Post post) {
        if (likeRepository.existsByUserAndPost(user, post)) {
            throw new IllegalArgumentException("이미 좋아요 존재");
        }
        Like like = Like.create(user, post);
        likeRepository.save(like);
    }

    // 좋아요 해제
    @Transactional
    public void unlikePost(User user, Post post) {
        if (!likeRepository.existsByUserAndPost(user, post)) {
            throw new IllegalArgumentException("좋아요 누른 적 없음");
        }
        likeRepository.deleteByUserAndPost(user, post);
    }

    // 좋아요 수
    @Transactional(readOnly = true) // 읽기 전용
    public int countLikes(Post post) {
        return likeRepository.countByPost(post);
    }
}
