package com.spring.blog_application.service;

import com.spring.blog_application.model.Post;
import com.spring.blog_application.model.Profile;
import com.spring.blog_application.model.User;
import com.spring.blog_application.repository.UserRepository;
import com.spring.blog_application.utils.RegisterRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(RegisterRequest request) {
        try {
            User user = User.builder()
                    .username(request.username())
                    .email(request.email())
                    .createdAt(LocalDate.now())
                    .posts(new ArrayList<>())
                    .profile(new Profile())
                    .enabled(false)
                    .build();
            userRepository.save(user);
        } catch (Exception e) {
            log.info("Error: {}", e.getMessage());
        }
    }

    public boolean doesUserExist(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    public boolean doesUserNotExist(String email) {
        User user = userRepository.findByEmail(email);
        return user == null;
    }

    public void activateUserAccount(String email) {
        User user = userRepository.findByEmail(email);
        user.setEnabled(true);
        userRepository.save(user);
    }
}
