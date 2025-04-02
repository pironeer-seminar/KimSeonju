package com.example.pironeer4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "likes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "post_id"})
})  // uniqueConstraints: (user_id, post_id) 조합이 중복되지 않도록 제약 = 같은 유저가 같은 글에 두 번 좋아요 못 누르게 막음.
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
