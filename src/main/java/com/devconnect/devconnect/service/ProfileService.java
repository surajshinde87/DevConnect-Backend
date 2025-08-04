package com.devconnect.devconnect.service;
import com.devconnect.devconnect.model.Profile;

import java.util.List;

public interface ProfileService {
 Profile createProfile(Long userId, Profile profile);
    Profile getProfileByUserId(Long userId);
    Profile updateProfile(Long profileId, Profile profileDetails);
    void deleteProfile(Long profileId);
    List<Profile> getAllProfiles();
}
