package com.devconnect.devconnect.serviceImpl;

import com.devconnect.devconnect.model.Profile;
import com.devconnect.devconnect.model.User;
import com.devconnect.devconnect.repository.ProfileRepository;
import com.devconnect.devconnect.repository.UserRepository;
import com.devconnect.devconnect.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Profile createProfile(Long userId, Profile profile) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        profile.setUser(user); // Associate user with profile
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileByUserId(Long userId) {
        return profileRepository.findByUserId(userId);
    }

    @Override
    public Profile updateProfile(Long profileId, Profile profileDetails) {
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            profile.setBio(profileDetails.getBio());
            profile.setSkills(profileDetails.getSkills());
            profile.setExperience(profileDetails.getExperience());
            profile.setGithub(profileDetails.getGithub());
            return profileRepository.save(profile);
        }
        return null;
    }

    @Override
    public void deleteProfile(Long profileId) {
        profileRepository.deleteById(profileId);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}
