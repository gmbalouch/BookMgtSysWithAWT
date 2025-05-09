package com.educonnet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonnet.entity.User;
import com.educonnet.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void signup(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        userRepository.save(user);
    }

    public boolean signin(User user) {
        Optional<User> userOpt = userRepository.findByUsername(user.getUsername());

        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        if (!userOpt.get().getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return true;
    }
}
