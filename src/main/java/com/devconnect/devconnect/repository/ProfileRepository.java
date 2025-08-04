package com.devconnect.devconnect.repository;

import com.devconnect.devconnect.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByUserId(Long userId);
}
