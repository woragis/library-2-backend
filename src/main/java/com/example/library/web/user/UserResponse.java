package com.example.library.web.user;

import java.time.LocalDate;
import java.util.UUID;

import com.example.library.domain.user.User;
import com.example.library.domain.user.UserRole;

public record UserResponse(
        UUID id,
        String name,
        String username,
        String email,
        LocalDate dateOfBirth,
        UserRole role) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getDateOfBirth(),
                user.getRole());
    }
}
