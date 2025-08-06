package com.devconnect.devconnect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devconnect.devconnect.service.CommentService;
import com.devconnect.devconnect.model.Comment;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestParam Long blogId,
            @RequestParam Long userId,
            @RequestParam String content) {
        return ResponseEntity.ok(commentService.addComment(blogId, userId, content));
    }

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long blogId) {
        return ResponseEntity.ok(commentService.getCommentsByBlog(blogId));
    }
}
