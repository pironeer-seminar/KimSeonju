package com.example.demo1.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 공통 엔티티
@Getter
@MappedSuperclass // 해당 클래스를 직접 DB 테이블로 만들지 않고, 자식 클래스가 이 필드들을 상속받아 사용할 수 있게 함, 즉, 테이블이 아니라 상속용
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate  // 처음 저장될 때 자동으로 현재 시간을 넣어줌
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
