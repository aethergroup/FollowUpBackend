package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymCreatedAt Value Object Tests")
class GymCreatedAtExtendedTest {

    @Test
    @DisplayName("Should create GymCreatedAt with valid timestamp")
    void testCreateValidTimestamp() {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        GymCreatedAt createdAt = new GymCreatedAt(now);
        assertNotNull(createdAt);
    }

    @Test
    @DisplayName("Should throw exception for null timestamp")
    void testNullTimestampThrowsException() {
        assertThrows(Exception.class, () -> new GymCreatedAt(null));
    }

    @Test
    @DisplayName("Should store timestamp value correctly")
    void testTimestampValueStorage() {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        GymCreatedAt createdAt = new GymCreatedAt(now);
        assertEquals(now, createdAt.getValue());
    }

    @Test
    @DisplayName("Should handle different timestamps")
    void testDifferentTimestamps() {
        Timestamp past = Timestamp.valueOf(LocalDateTime.now().minusHours(1));
        Timestamp present = Timestamp.valueOf(LocalDateTime.now());
        GymCreatedAt createdAt1 = new GymCreatedAt(past);
        GymCreatedAt createdAt2 = new GymCreatedAt(present);
        assertNotNull(createdAt1);
        assertNotNull(createdAt2);
    }
}
