package com.example.library.web.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.application.user.UserService;
import com.example.library.domain.user.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest req) {
        User user = service.register(
                req.name(),
                req.username(),
                req.email(),
                req.password(),
                req.dateOfBirth(),
                req.role());
        return ResponseEntity.ok(UserResponse.from(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody AuthRequest req) {
        return service.login(req.username(), req.password())
                .map(UserResponse::from)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}
