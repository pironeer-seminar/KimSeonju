package com.example.pironeer.domain;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id   // @Id: 기본 키 (Primary Key) 필드
    @GeneratedValue(strategy = GenerationType.AUTO)  // @GeneratedValue(...) : 기본 키를 자동으로 생성해주는 JPA 기능

    public Long id;

    public String username;
    public String email;

    // Order와의 연관관계(1:N)
    // User 입장에서는 여러 Ooder를 가짐 -> User 엔티티는 List<Order> 컬렉션을 가져야 함
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)  // mappedBy = "user"라고 명시해서 나는 주인이 아니다
    private List<Order> orders = new ArrayList<>();

    protected User(){}    // JPA는 프록시 생성을 위해 기본 생성자가 필수

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public String getName(){
        return username;
    }
}
