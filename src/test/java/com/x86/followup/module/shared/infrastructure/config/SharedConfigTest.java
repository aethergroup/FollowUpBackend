package com.x86.followup.module.shared.infrastructure.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Shared Configuration Tests")
class SharedConfigTest {

    @Test
    @DisplayName("Should have password encoder available")
    void testPasswordEncoderExists() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertNotNull(encoder);
    }

    @Test
    @DisplayName("Should encode password successfully")
    void testPasswordEncoding() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password123";
        String encoded = encoder.encode(rawPassword);
        assertNotNull(encoded);
        assertTrue(encoded.startsWith("$2a$"));
    }

    @Test
    @DisplayName("Should verify encoded password")
    void testPasswordVerification() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "mypassword";
        String encoded = encoder.encode(rawPassword);
        assertTrue(encoder.matches(rawPassword, encoded));
    }
}
