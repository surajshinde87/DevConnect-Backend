package com.devconnect.devconnect.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconnect.devconnect.model.User;
import com.devconnect.devconnect.repository.UserRepository;
import com.devconnect.devconnect.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setLocation(userDetails.getLocation());
            user.setProfileImage(userDetails.getProfileImage());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

  @Override
public String followUser(Long followerId, Long followeeId) {
    User follower = userRepository.findById(followerId)
        .orElseThrow(() -> new RuntimeException("Follower not found"));
    User followee = userRepository.findById(followeeId)
        .orElseThrow(() -> new RuntimeException("Followee not found"));

    // Logic to follow
    follower.getFollowing().add(followee);
    followee.getFollowers().add(follower);
    userRepository.save(follower);
    userRepository.save(followee);

    // Return custom message
    return "You started following " + followee.getName() + ";;" +
           follower.getName() + " started following you";
}

@Override
public String unfollowUser(Long followerId, Long followeeId) {
    User follower = userRepository.findById(followerId)
        .orElseThrow(() -> new RuntimeException("Follower not found"));
    User followee = userRepository.findById(followeeId)
        .orElseThrow(() -> new RuntimeException("Followee not found"));

    // Logic to unfollow
    follower.getFollowing().remove(followee);
    followee.getFollowers().remove(follower);
    userRepository.save(follower);
    userRepository.save(followee);

    return "You unfollowed " + followee.getName() + ";;" +
           follower.getName() + " unfollowed you";
}

}
