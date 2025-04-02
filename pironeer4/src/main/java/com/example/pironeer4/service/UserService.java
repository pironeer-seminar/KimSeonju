package com.example.pironeer4.service;

import com.example.pironeer4.dto.request.UserCreateReq;
import com.example.pironeer4.entity.User;
import com.example.pironeer4.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor  // final 필드용 생성자 자동 생성
public class UserService {

    private final UserRepository userRepository;

    // 의존성 생성자
    // public UserService(UserRepository userRepository) {
    //        this.userRepository = userRepository;
    //    } -> @RequiredArgsConstructor 가 자동 생성

    public Long create(UserCreateReq req) {
        User user = User.create(req.getName());  // 요청에서 이름을 받아와서 객체 생성
        user = userRepository.save(user);  // DB 저장

        return user.getId();  // ID 반환
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없음"));
    }
}