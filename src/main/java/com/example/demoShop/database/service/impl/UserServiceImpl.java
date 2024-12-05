package com.example.demoShop.database.service.impl;

import com.example.demoShop.database.entity.User;
import com.example.demoShop.database.repository.UserRepository;
import com.example.demoShop.database.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Пользователя с ID: %d не надено".formatted(id)));
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("Пользователя с ником: %d не надено".formatted(username)));
    }

    public User findUserByEmail(String email) {
        return userRepository.findByUsername(email).orElseThrow(() -> new EntityNotFoundException("Пользователя с ником: %d не надено".formatted(email)));
    }

    public User updateUser(Long id, User user) {
        User existingUser = findUserById(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhone(user.getPhone());
        existingUser.setAddress(user.getAddress());
        existingUser.setCity(user.getCity());
        return userRepository.save(existingUser);
    }
    public void deleteUser (Long id) {
        userRepository.deleteById(id);
    }
}
