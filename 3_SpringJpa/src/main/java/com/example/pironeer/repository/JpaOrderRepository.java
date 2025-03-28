package com.example.pironeer.repository;

import org.hibernate.query.criteria.JpaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<JpaOrder, Long> {
}
