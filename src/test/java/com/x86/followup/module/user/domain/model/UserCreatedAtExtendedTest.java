package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserCreatedAt Value Object Tests")
class UserCreatedAtExtendedTest {

    @Test
    @DisplayName("Should create UserCreatedAt with valid timestamp")
    void testCreateValidTimestamp() {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        UserCreatedAt createdAt = new UserCreatedAt(now);
        assertNotNull(createdAt);
    }

    @Test
    @DisplayName("Should throw exception for null timestamp")
    void testNullTimestampThrowsException() {
        assertThrows(Exception.class, () -> new UserCreatedAt(null));
    }

    @Test
    @DisplayName("Should store timestamp value correctly")
    void testTimestampValueStorage() {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        UserCreatedAt createdAt = new UserCreatedAt(now);
        assertEquals(now, createdAt.getValue());
    }

    @Test
    @DisplayName("Should handle different timestamps")
    void testDifferentTimestamps() {
        Timestamp past = Timestamp.valueOf(LocalDateTime.now().minusDays(1));
        Timestamp present = Timestamp.valueOf(LocalDateTime.now());
        UserCreatedAt createdAt1 = new UserCreatedAt(past);
        UserCreatedAt createdAt2 = new UserCreatedAt(present);
        assertNotNull(createdAt1);
        assertNotNull(createdAt2);
    }
}
