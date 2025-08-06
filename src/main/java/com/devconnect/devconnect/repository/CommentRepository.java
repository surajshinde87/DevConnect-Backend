package com.devconnect.devconnect.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.devconnect.devconnect.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogId(Long blogId);
}
 
