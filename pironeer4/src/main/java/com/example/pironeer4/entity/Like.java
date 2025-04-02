package com.example.pironeer4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "likes")
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false, name = "post_id")
    private Post post;

    public static Like create(User user, Post post) {
        return Like.builder()
                .user(user)
                .post(post)
                .build();
    }

}
