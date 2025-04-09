package com.example.demo1.Post.entity;

import com.example.demo1.common.BaseTimeEntity;
import com.example.demo1.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@EntityListeners(AuditingEntityListener.class)
// @EntityListeners : JPA가 엔티티의 생명 주기 이벤트을 감지할 수 있께 해줌
// AuditingEntityListener.class : @CreatedDate, @LastModifiedDate가 적용된 필드들을 자동으로 채움
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private PostStatus status;

//    @CreatedDate   // 엔티티가 처음 생성되어 저장될 때, 자동으로 현자 날짜와 시간이 기록됨.
//    @Column(nullable = false, updatable = false) // updatable: false : 수정 시 이 값은 변경 X
//    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;


    public static Post create(User author, String title, String content, PostStatus status) {
        return Post.builder()
                .user(author)
                .title(title)
                .content(content)
                .status(status)
                .build();  // createdAt을 채우지 않아도 된다
    }

    public void update(String title, String content, PostStatus status) {
        this.title = title;
        this.content = content;
        this.status = status;
    }
}
