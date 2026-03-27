package com.x86.followup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FollowupApplication {

	public static void main(String[] args) {
		SpringApplication.run(FollowupApplication.class, args);
	}

}
