package com.example.library.application.user;

import com.example.library.domain.user.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User register(String name, String username, String email, String password, LocalDate dob, UserRole role) {
        if (repository.findByUsername(username).isPresent() || repository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Username or email already taken");
        }
        String hashed = passwordEncoder.encode(password);
        User user = new User(UUID.randomUUID(), name, username, email, hashed, dob, role);
        return repository.save(user);
    }

    public Optional<User> login(String username, String password) {
        Optional<User> userOpt = repository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }

    public Optional<User> getById(UUID id) {
        return repository.findById(id);
    }
}
