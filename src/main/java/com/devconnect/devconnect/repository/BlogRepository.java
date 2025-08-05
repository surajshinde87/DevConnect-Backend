package com.devconnect.devconnect.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devconnect.devconnect.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByUserId(Long userId);
}
