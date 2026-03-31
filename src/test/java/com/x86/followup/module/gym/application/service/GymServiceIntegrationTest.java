package com.x86.followup.module.gym.application.service;

import com.x86.followup.module.gym.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("GymService Integration Tests")
class GymServiceIntegrationTest {

    @Test
    @DisplayName("Should create minimal Gym object")
    void testGymCreation() {
        Gym gym = new Gym(
                new GymId(1),
                new GymName("Test Gym"),
                new GymEmail("test@gym.com"),
                new GymPhone("+1 123"),
                new GymAddress("123 St"),
                new GymPasswordHash("pwd"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );

        assertNotNull(gym);
        assertEquals(1, gym.getId().getValue());
    }

    @Test
    @DisplayName("Should handle optional Gym ID")
    void testOptionalGymId() {
        Gym gym = new Gym(
                null,
                new GymName("New Gym"),
                new GymEmail("new@gym.com"),
                new GymPhone("+1 456"),
                new GymAddress("456 Ave"),
                new GymPasswordHash("pwd2"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );

        assertTrue(gym.getId() == null);
    }
}
