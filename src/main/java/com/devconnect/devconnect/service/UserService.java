package com.devconnect.devconnect.service;

import com.devconnect.devconnect.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    String followUser(Long followerId, Long followeeId);
String unfollowUser(Long followerId, Long followeeId);
}
