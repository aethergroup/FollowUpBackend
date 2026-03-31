package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Gym Domain Model Tests")
class GymTest {

    private Gym createTestGym() {
        return new Gym(
                new GymId(1),
                new GymName("Test Gym"),
                new GymEmail("test@gym.com"),
                new GymPhone("+1 234567890"),
                new GymAddress("123 Main St"),
                new GymPasswordHash("hashed_password"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should create a Gym with valid parameters")
    void testGymCreation() {
        Gym gym = createTestGym();
        assertNotNull(gym);
        assertEquals(1, gym.getId().getValue());
        assertEquals("Test Gym", gym.getName().getValue());
        assertEquals("test@gym.com", gym.getEmail().getValue());
    }

    @Test
    @DisplayName("Should throw NullPointerException when name is null")
    void testGymCreationWithNullName() {
        assertThrows(NullPointerException.class, () -> new Gym(
                new GymId(1),
                null,
                new GymEmail("test@gym.com"),
                new GymPhone("+1 234567890"),
                new GymAddress("123 Main St"),
                new GymPasswordHash("hashed_password"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        ));
    }

    @Test
    @DisplayName("Should throw NullPointerException when email is null")
    void testGymCreationWithNullEmail() {
        assertThrows(NullPointerException.class, () -> new Gym(
                new GymId(1),
                new GymName("Test Gym"),
                null,
                new GymPhone("+1 234567890"),
                new GymAddress("123 Main St"),
                new GymPasswordHash("hashed_password"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        ));
    }

    @Test
    @DisplayName("Should throw NullPointerException when phone is null")
    void testGymCreationWithNullPhone() {
        assertThrows(NullPointerException.class, () -> new Gym(
                new GymId(1),
                new GymName("Test Gym"),
                new GymEmail("test@gym.com"),
                null,
                new GymAddress("123 Main St"),
                new GymPasswordHash("hashed_password"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        ));
    }

    @Test
    @DisplayName("Should throw NullPointerException when address is null")
    void testGymCreationWithNullAddress() {
        assertThrows(NullPointerException.class, () -> new Gym(
                new GymId(1),
                new GymName("Test Gym"),
                new GymEmail("test@gym.com"),
                new GymPhone("+1 234567890"),
                null,
                new GymPasswordHash("hashed_password"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        ));
    }

    @Test
    @DisplayName("Should throw NullPointerException when password hash is null")
    void testGymCreationWithNullPasswordHash() {
        assertThrows(NullPointerException.class, () -> new Gym(
                new GymId(1),
                new GymName("Test Gym"),
                new GymEmail("test@gym.com"),
                new GymPhone("+1 234567890"),
                new GymAddress("123 Main St"),
                null,
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        ));
    }
}
