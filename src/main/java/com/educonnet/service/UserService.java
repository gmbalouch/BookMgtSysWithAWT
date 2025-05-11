package com.educonnet.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.educonnet.entity.User;
import com.educonnet.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User signup(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User savedUser = userRepository.save(user);
        return savedUser;
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

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>());
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
