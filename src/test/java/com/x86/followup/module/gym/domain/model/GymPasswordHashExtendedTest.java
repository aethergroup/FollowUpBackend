package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymPasswordHash Value Object Tests")
class GymPasswordHashExtendedTest {

    @Test
    @DisplayName("Should create GymPasswordHash with valid value")
    void testCreateValidHash() {
        GymPasswordHash hash = new GymPasswordHash("$2a$10$dXBlcmlhbHRlc3Q=");
        assertNotNull(hash);
    }

    @Test
    @DisplayName("Should throw exception for null hash")
    void testNullHashThrowsException() {
        assertThrows(Exception.class, () -> new GymPasswordHash(null));
    }

    @Test
    @DisplayName("Should store hash value correctly")
    void testHashValueStorage() {
        String value = "$2a$10$hashedpassword123456";
        GymPasswordHash hash = new GymPasswordHash(value);
        assertEquals(value, hash.getValue());
    }

    @Test
    @DisplayName("Should handle different password hash formats")
    void testDifferentHashFormats() {
        GymPasswordHash hash1 = new GymPasswordHash("$2a$10$simple");
        GymPasswordHash hash2 = new GymPasswordHash("$2a$10$bcrypt.algorithm.test.hash");
        GymPasswordHash hash3 = new GymPasswordHash("$2a$10$verylonghashvaluewithspecialcharacters123456789");
        assertNotNull(hash1);
        assertNotNull(hash2);
        assertNotNull(hash3);
    }
}
