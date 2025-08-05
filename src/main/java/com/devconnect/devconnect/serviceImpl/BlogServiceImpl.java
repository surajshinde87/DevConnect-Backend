package com.devconnect.devconnect.serviceImpl;

import com.devconnect.devconnect.dto.BlogDto;
import com.devconnect.devconnect.model.Blog;
import com.devconnect.devconnect.model.User;
import com.devconnect.devconnect.repository.BlogRepository;
import com.devconnect.devconnect.repository.UserRepository;
import com.devconnect.devconnect.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        User user = userRepository.findById(blogDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setCreatedAt(blogDto.getCreatedAt());
        blog.setUser(user);

        Blog saved = blogRepository.save(blog);

        // Return saved BlogDto
        blogDto.setCreatedAt(saved.getCreatedAt());
        return blogDto;
    }

    @Override
    public List<BlogDto> getBlogsByUser(Long userId) {
        return blogRepository.findByUserId(userId).stream()
                .map(blog -> new BlogDto(blog.getTitle(), blog.getContent(), blog.getUser().getId(), blog.getCreatedAt()))
                .collect(Collectors.toList());
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        return blogRepository.findAll().stream()
                .map(blog -> new BlogDto(blog.getTitle(), blog.getContent(), blog.getUser().getId(), blog.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
