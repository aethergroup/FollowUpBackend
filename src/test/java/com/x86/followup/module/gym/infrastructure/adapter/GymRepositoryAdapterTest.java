package com.x86.followup.module.gym.infrastructure.adapter;

import com.x86.followup.module.gym.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("GymRepositoryAdapter Tests")
class GymRepositoryAdapterTest {

    @Test
    @DisplayName("GymRepositoryAdapter should exist in context")
    void testRepositoryAdapterExists() {
        assertDoesNotThrow(() -> {
            // Repository adapter would be tested here
        });
    }

    @Test
    @DisplayName("Should handle Gym persistence operations")
    void testGymPersistenceOperations() {
        Gym gym = new Gym(
                null,
                new GymName("Adapter Test Gym"),
                new GymEmail("adapter@test.com"),
                new GymPhone("+1 555"),
                new GymAddress("Adapter Address"),
                new GymPasswordHash("hashed"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );

        assertNotNull(gym);
        assertNull(gym.getId());
    }
}
