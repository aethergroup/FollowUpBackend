package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Gym Domain Model Tests")
class GymDomainModelTest {

    @Test
    @DisplayName("Should validate Gym model structure")
    void testGymModelStructure() {
        assertDoesNotThrow(() -> {
            Gym gym = new Gym(
                    new GymId(1),
                    new GymName("Test Gym"),
                    new GymEmail("test@gym.com"),
                    new GymPhone("+1 234"),
                    new GymAddress("Test Address"),
                    new GymPasswordHash("hashed"),
                    new GymCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()))
            );
            assertNotNull(gym);
        });
    }

    @Test
    @DisplayName("Should handle Gym with all required fields")
    void testGymWithAllFields() {
        Gym gym = new Gym(
                new GymId(1),
                new GymName("Complete Gym"),
                new GymEmail("complete@example.com"),
                new GymPhone("+1 555 1234"),
                new GymAddress("123 Main St"),
                new GymPasswordHash("$2a$10$hashedvalue"),
                new GymCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()))
        );
        assertNotNull(gym.getId());
        assertNotNull(gym.getName());
        assertNotNull(gym.getEmail());
    }
}
