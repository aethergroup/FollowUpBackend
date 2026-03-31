package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymPasswordHash Value Object Tests")
class GymPasswordHashTest {

    @Test
    @DisplayName("Should create GymPasswordHash successfully")
    void testCreateGymPasswordHashSuccess() {
        GymPasswordHash hash = new GymPasswordHash("$2a$10$hashedpassword");
        assertNotNull(hash);
        assertEquals("$2a$10$hashedpassword", hash.getValue());
    }

    @Test
    @DisplayName("Should fail when hash is null")
    void testGymPasswordHashNull() {
        assertThrows(NullPointerException.class, () -> new GymPasswordHash(null));
    }

    @Test
    @DisplayName("Should store hash value")
    void testGymPasswordHashValue() {
        GymPasswordHash hash = new GymPasswordHash("encrypted_value");
        assertNotNull(hash.getValue());
    }
}
