package com.devconnect.devconnect.dto;

public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String location;
    private String profileImage;

    public UserResponseDto() {}

    public UserResponseDto(Long id, String name, String email, String location, String profileImage) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
        this.profileImage = profileImage;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
