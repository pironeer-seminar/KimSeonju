package com.example.pironeer.repository;

import com.example.pironeer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Integer> {

}
