package com.devconnect.devconnect.controller;

import com.devconnect.devconnect.model.Profile;
import com.devconnect.devconnect.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "*")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Create profile for a specific user
    @PostMapping("/create/{userId}")
    public Profile createProfile(@PathVariable Long userId, @RequestBody Profile profile) {
        return profileService.createProfile(userId, profile);
    }

    // Get profile by user ID
    @GetMapping("/{userId}")
    public Profile getProfileByUserId(@PathVariable Long userId) {
        return profileService.getProfileByUserId(userId);
    }

    // Update profile by profile ID
    @PutMapping("/update/{profileId}")
    public Profile updateProfile(@PathVariable Long profileId, @RequestBody Profile profileDetails) {
        return profileService.updateProfile(profileId, profileDetails);
    }

    // Delete profile by profile ID
    @DeleteMapping("/delete/{profileId}")
    public void deleteProfile(@PathVariable Long profileId) {
        profileService.deleteProfile(profileId);
    }

    // Get all profiles
    @GetMapping("/all")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }
}
