package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymName Value Object Tests")
class GymNameTest {

    @Test
    @DisplayName("Should create GymName successfully")
    void testCreateGymNameSuccess() {
        GymName name = new GymName("Fitness Pro");
        assertNotNull(name);
        assertEquals("Fitness Pro", name.getValue());
    }

    @Test
    @DisplayName("Should fail when name is null")
    void testGymNameNull() {
        assertThrows(NullPointerException.class, () -> new GymName(null));
    }

    @Test
    @DisplayName("Should handle empty name")
    void testGymNameEmpty() {
        GymName name = new GymName("");
        assertEquals("", name.getValue());
    }

    @Test
    @DisplayName("Should validate name length")
    void testGymNameLength() {
        String longName = "A".repeat(1000);
        GymName name = new GymName(longName);
        assertEquals(longName, name.getValue());
    }
}
