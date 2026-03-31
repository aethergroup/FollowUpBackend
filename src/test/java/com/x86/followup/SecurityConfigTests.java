package com.x86.followup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("SecurityConfig Tests")
class SecurityConfigTests {

    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("PasswordEncoder should be configured")
    void testPasswordEncoderExists() {
        assertNotNull(passwordEncoder, "PasswordEncoder should be configured in Spring context");
    }

    @Test
    @DisplayName("PasswordEncoder should encode passwords")
    void testPasswordEncodingWorks() {
        if (passwordEncoder != null) {
            String rawPassword = "testPassword123";
            String encodedPassword = passwordEncoder.encode(rawPassword);
            
            assertNotNull(encodedPassword);
            assertNotEquals(rawPassword, encodedPassword, "Password should be encoded and different from original");
        }
    }

    @Test
    @DisplayName("PasswordEncoder should verify encoded passwords")
    void testPasswordMatchingWorks() {
        if (passwordEncoder != null) {
            String rawPassword = "testPassword123";
            String encodedPassword = passwordEncoder.encode(rawPassword);
            
            assertTrue(passwordEncoder.matches(rawPassword, encodedPassword),
                    "Password match should return true for correct password");
            assertFalse(passwordEncoder.matches("wrongPassword", encodedPassword),
                    "Password match should return false for incorrect password");
        }
    }
}
