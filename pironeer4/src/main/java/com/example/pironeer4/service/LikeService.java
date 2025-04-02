package com.example.pironeer4.service;

import com.example.pironeer4.entity.Like;
import com.example.pironeer4.entity.Post;
import com.example.pironeer4.entity.User;
import com.example.pironeer4.repository.LikeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {

    private final LikeRepository likeRepository;

    // 좋아요 생성
    public void likePost(User user, Post post) {
        if (likeRepository.existByUserAndPost(user, post)) {
            throw new IllegalArgumentException("이미 좋아요 존재");
        }
        Like like = Like.create(user, post);
        likeRepository.save(like);
    }

    // 좋아요 해제
    public void unlikePost(User user, Post post) {
        if (!likeRepository.existByUserAndPost(user, post)) {
            throw new IllegalArgumentException("좋아요 누른 적 없음");
        }
        likeRepository.deleteByUserAndPost(user, post);
    }

    // 좋아요 수
    public int countLikes(Post post) {
        return likeRepository.countByPost(post);
    }
}
