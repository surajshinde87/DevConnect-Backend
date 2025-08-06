package com.devconnect.devconnect.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconnect.devconnect.model.Blog;
import com.devconnect.devconnect.model.Comment;
import com.devconnect.devconnect.model.User;
import com.devconnect.devconnect.repository.BlogRepository;
import com.devconnect.devconnect.repository.CommentRepository;
import com.devconnect.devconnect.repository.UserRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private BlogRepository blogRepo;

    @Autowired
    private UserRepository userRepo;

    public Comment addComment(Long blogId, Long userId, String content) {
        Blog blog = blogRepo.findById(blogId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setBlog(blog);
        comment.setUser(user);
        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsByBlog(Long blogId) {
        return commentRepo.findByBlogId(blogId);
    }
}

