package com.devconnect.devconnect.controller;

import com.devconnect.devconnect.dto.BlogDto;
import com.devconnect.devconnect.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public BlogDto createBlog(@RequestBody BlogDto blogDto) {
        return blogService.createBlog(blogDto);
    }

    @GetMapping("/user/{userId}")
    public List<BlogDto> getBlogsByUser(@PathVariable Long userId) {
        return blogService.getBlogsByUser(userId);
    }

    @GetMapping
    public List<BlogDto> getAllBlogs() {
        return blogService.getAllBlogs();
    }
}
