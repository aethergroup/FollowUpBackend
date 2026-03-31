package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Gym Model Integration Tests")
class GymModelIntegrationTest {

    @Test
    @DisplayName("Should create complete Gym with all fields populated")
    void testCreateCompleteGym() {
        GymId id = new GymId(1);
        GymName name = new GymName("Elite Fitness");
        GymEmail email = new GymEmail("elite@fitness.com");
        GymPhone phone = new GymPhone("+1 5551234567");
        GymAddress address = new GymAddress("123 Main St, City");
        GymPasswordHash passwordHash = new GymPasswordHash("$2a$10$encrypted");
        GymCreatedAt createdAt = new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        Gym gym = new Gym(id, name, email, phone, address, passwordHash, createdAt);

        assertNotNull(gym);
        assertEquals(1, gym.getId().getValue());
        assertEquals("Elite Fitness", gym.getName().getValue());
        assertTrue(gym.getEmail().getValue().contains("@"));
    }

    @Test
    @DisplayName("Should handle Gym with null ID")
    void testGymWithNullId() {
        Gym gym = new Gym(
                null,
                new GymName("New Gym"),
                new GymEmail("new@gym.com"),
                new GymPhone("+1 555"),
                new GymAddress("123 New St"),
                new GymPasswordHash("pwd"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );

        assertNotNull(gym);
        assertNull(gym.getId());
    }

    @Test
    @DisplayName("Should validate all required fields")
    void testGymRequiredFields() {
        assertThrows(NullPointerException.class, () -> 
            new Gym(null, null, new GymEmail("test@gym.com"), 
                    new GymPhone("+1 555"), new GymAddress("123"),
                    new GymPasswordHash("pwd"), new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now())))
        );
    }
}
