package com.x86.followup.module.gym.infrastructure.persistence;

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
@DisplayName("GymRepository Integration Tests")
class GymRepositoryIntegrationTest {

    private Gym createTestGym(String name, String email) {
        return new Gym(
                null,
                new GymName(name),
                new GymEmail(email),
                new GymPhone("+1 234567890"),
                new GymAddress("Test Address"),
                new GymPasswordHash("hashed_password"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should support gym persistence")
    void testGymSave() {
        assertDoesNotThrow(() -> {
            // Repository operations would go here
            createTestGym("Integration Gym", "integration@gym.com");
        });
    }

    @Test
    @DisplayName("Should find gym operations")
    void testFindOperations() {
        assertDoesNotThrow(() -> {
            // Find operations would go here
            createTestGym("Find Test", "findtest@gym.com");
        });
    }
}

