package com.example.pironeer.service;

import com.example.pironeer.domain.User;
import com.example.pironeer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository; // UserService 클래스는 DB랑 소통해야 하니까 JpaUserRepository가 필요해

    //의존성 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 등록
    public User registerUser(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user); // DB에 저장
    }

    // 유저 단건 조회
    public User findUserByID(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

    }

    // 유저 전체 조화
    public List<User> findUserAll() {    // 모든 유저 목록을 리스트로 변환
        return userRepository.findAll();
    }
}
