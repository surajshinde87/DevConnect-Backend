package com.devconnect.devconnect.service;

import java.util.List;

import com.devconnect.devconnect.dto.BlogDto;

public interface BlogService {
    BlogDto createBlog(BlogDto blogDto);
    List<BlogDto> getBlogsByUser(Long userId);
    List<BlogDto> getAllBlogs();
}
