package com.example.pironeer.service;

import com.example.pironeer.repository.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final JpaUserRepository userRepository;
}
