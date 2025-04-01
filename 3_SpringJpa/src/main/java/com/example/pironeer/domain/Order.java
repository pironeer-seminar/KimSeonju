package com.example.pironeer.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    // User와의 연관관계
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    //OrderItem과의 연관관계
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    public List<OrderItem> orderItemList = new ArrayList<>();  // 현재 주문(Order)에 포함된 모든 상품(OrderItem) 을 담는

    public String status;  // 주문상태 (ORDERED, CANCELED)
    public LocalDateTime orderDate;  // 주문날짜

    protected Order(){}

    public Order(User user, String status, LocalDateTime orderDate){
        this.user = user;
        this.status = status;
        this.orderDate = LocalDateTime.now();
    }

    // 주문상품 하나를 주문에 등록
    public void addOrderItem(OrderItem orderItem){
        orderItemList.add(orderItem); // 주문상품 추가
        orderItem.order = this;  //OrderItem 입장에서는 자신의 order 필드가 어떤 주문에 속해 있는지 나타냄, 지금 이 주문(this)을 OrderItem에게 “너는 나한테 속한 거야” 라고 알려주는 것
    }

    // 주문 취소
    public void cancel(){
        if ("CANCELED".equals(this.status)) {
            throw new IllegalStateException("이미 취소된 주문입니다.");
        }
        this.status = "CANCELED";
        for (OrderItem item : orderItemList) {
            item.cancel();
        }
    }

    public String getStatus() {
        return status;

    }
}
