package com.example.demoShop.database.service;

import com.example.demoShop.database.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {
    User findUserById(Long id);

    User findUserByUsername(String username);
}
