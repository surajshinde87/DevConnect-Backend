package com.devconnect.devconnect.dto;

import java.time.LocalDateTime;

public class BlogDto {
    private String title;
    private String content;
    private Long userId; // Link to User
    private LocalDateTime createdAt;

    // Constructors
    public BlogDto() {}

    public BlogDto(String title, String content, Long userId, LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    // Getters & Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
