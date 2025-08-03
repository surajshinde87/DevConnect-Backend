package com.devconnect.devconnect.repository;

import com.devconnect.devconnect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
