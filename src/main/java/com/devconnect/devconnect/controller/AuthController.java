package com.devconnect.devconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconnect.devconnect.dto.UserLoginDto;
import com.devconnect.devconnect.dto.UserRegisterDto;
import com.devconnect.devconnect.dto.UserResponseDto;
import com.devconnect.devconnect.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public UserResponseDto register(@Valid @RequestBody UserRegisterDto userDto) {
        return authService.register(userDto);
    }

    @PostMapping("/login")
    public UserResponseDto login(@Valid @RequestBody UserLoginDto loginDto) {
        return authService.login(loginDto);
    }

    @PutMapping("/update/{userId}")
    public UserResponseDto update(@PathVariable Long userId,
                                  @Valid @RequestBody UserRegisterDto updateDto) {
        return authService.updateUser(userId, updateDto);
    }

    @PostMapping("/signout")
    public String signout() {
        // Client handles sign out (remove token/session)
        return "Signed out successfully";
    }
}
