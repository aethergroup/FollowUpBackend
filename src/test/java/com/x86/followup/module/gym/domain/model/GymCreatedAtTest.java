package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymCreatedAt Value Object Tests")
class GymCreatedAtTest {

    @Test
    @DisplayName("Should create GymCreatedAt successfully")
    void testCreateGymCreatedAtSuccess() {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        GymCreatedAt createdAt = new GymCreatedAt(now);
        assertNotNull(createdAt);
        assertEquals(now, createdAt.getValue());
    }

    @Test
    @DisplayName("Should store timestamp value")
    void testGymCreatedAtValue() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        GymCreatedAt createdAt = new GymCreatedAt(timestamp);
        assertNotNull(createdAt.getValue());
    }

    @Test
    @DisplayName("Should handle current timestamp")
    void testGymCreatedAtCurrent() {
        GymCreatedAt createdAt = new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        assertTrue(createdAt.getValue().getTime() > 0);
    }
}
