package com.joaoricardo.listify.controller;

import com.joaoricardo.listify.dto.auth.RegisterRequest;
import com.joaoricardo.listify.entity.User;
import com.joaoricardo.listify.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.joaoricardo.listify.dto.auth.LoginRequest;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    /*REGISTRO*/
    @PostMapping("/register")
    public User register(@RequestBody @Valid RegisterRequest request) {
        return userService.register(request);
    }

    /*LOGIN*/
    @PostMapping("/login")
    public User login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request);
    }
}