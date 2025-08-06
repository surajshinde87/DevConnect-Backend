package com.devconnect.devconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devconnect.devconnect.service.UserService;



@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private UserService userService;

   @PostMapping("/{followerId}/follow/{followeeId}")
public ResponseEntity<String> followUser(@PathVariable Long followerId, @PathVariable Long followeeId) {
    String result = userService.followUser(followerId, followeeId);
    String[] parts = result.split(";;");
    String followerMsg = parts[0]; // Message for current user
    return ResponseEntity.ok(followerMsg);
}

@PostMapping("/{followerId}/unfollow/{followeeId}")
public ResponseEntity<String> unfollowUser(@PathVariable Long followerId, @PathVariable Long followeeId) {
    String result = userService.unfollowUser(followerId, followeeId);
    String[] parts = result.split(";;");
    String followerMsg = parts[0];
    return ResponseEntity.ok(followerMsg);
}

}
