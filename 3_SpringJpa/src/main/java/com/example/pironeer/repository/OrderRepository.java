package com.example.pironeer.repository;


import com.example.pironeer.domain.Order;
import org.hibernate.query.criteria.JpaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId); // SELECT * FROM orders WHERE user_id = ?
                                           // 특정 유저가 했던 모든 주문을 가져오기
                                           // findBy + [필드이름]
}
