package com.example.pironeer4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "users")
@Builder(access = AccessLevel.PRIVATE)             // 빌더 메서드 생성, 객체 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 자동 생성, protected User() {}
@AllArgsConstructor(access = AccessLevel.PRIVATE)  // 모든 필드 받는 생성자
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;


    public static User create(String name) {
        return User.builder()
                .name(name)
                .build();
    }
}


