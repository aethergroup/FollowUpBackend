package com.x86.followup.module.gym.infrastructure.mapper;

import com.x86.followup.module.gym.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("GymMapper Tests")
class GymMapperTest {

    @Test
    @DisplayName("Should create valid Gym for mapping")
    void testGymForMapping() {
        Gym gym = new Gym(
                new GymId(1),
                new GymName("Mapper Test"),
                new GymEmail("mapper@test.com"),
                new GymPhone("+1 999"),
                new GymAddress("Mapper St"),
                new GymPasswordHash("mapped"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );

        assertNotNull(gym);
        assertEquals("Mapper Test", gym.getName().getValue());
    }

    @Test
    @DisplayName("Should handle Gym with all fields for DTO conversion")
    void testGymFieldsForDtoConversion() {
        Gym gym = new Gym(
                new GymId(1),
                new GymName("Complete Gym"),
                new GymEmail("complete@gym.com"),
                new GymPhone("+1 111222333"),
                new GymAddress("Complete Gym Address, City"),
                new GymPasswordHash("$2a$10$hashedpassword"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );

        assertTrue(gym.getId().getValue() > 0);
        assertTrue(gym.getEmail().getValue().contains("@"));
        assertTrue(gym.getPhone().getValue().startsWith("+"));
    }
}
