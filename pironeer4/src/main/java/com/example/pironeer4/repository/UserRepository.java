package com.example.pironeer4.repository;

import com.example.pironeer4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

