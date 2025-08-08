package com.devconnect.devconnect.service;

import com.devconnect.devconnect.dto.UserLoginDto;
import com.devconnect.devconnect.dto.UserRegisterDto;
import com.devconnect.devconnect.dto.UserResponseDto;

public interface AuthService {
    UserResponseDto register(UserRegisterDto userDto);
    UserResponseDto login(UserLoginDto loginDto);
    UserResponseDto updateUser(Long userId, UserRegisterDto updateDto);
}
