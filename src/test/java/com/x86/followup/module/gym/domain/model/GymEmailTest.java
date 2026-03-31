package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymEmail Value Object Tests")
class GymEmailTest {

    @Test
    @DisplayName("Should create GymEmail successfully")
    void testCreateGymEmailSuccess() {
        GymEmail email = new GymEmail("gym@example.com");
        assertNotNull(email);
        assertEquals("gym@example.com", email.getValue());
    }

    @Test
    @DisplayName("Should fail when email is null")
    void testGymEmailNull() {
        assertThrows(NullPointerException.class, () -> new GymEmail(null));
    }

    @Test
    @DisplayName("Should store email value")
    void testGymEmailValue() {
        GymEmail email = new GymEmail("test@gym.com");
        assertTrue(email.getValue().contains("@"));
    }
}
