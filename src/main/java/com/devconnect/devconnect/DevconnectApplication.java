package com.devconnect.devconnect;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.devconnect.devconnect.model.User;
import com.devconnect.devconnect.repository.UserRepository;

@SpringBootApplication
public class DevconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevconnectApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			User user = new User("Rushikesh", "rushi@example.com");
			userRepository.save(user);
		};
	}
}
