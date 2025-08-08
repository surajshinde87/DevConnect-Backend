package com.devconnect.devconnect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDto {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public UserLoginDto() {}
    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
    // Getters & Setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
