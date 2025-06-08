package com.example.library.web.user;

import java.time.LocalDate;

import com.example.library.domain.user.UserRole;

public record RegisterRequest(
        String name,
        String username,
        String email,
        String password,
        LocalDate dateOfBirth,
        UserRole role) {
}
