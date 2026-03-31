package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymName Value Object Tests")
class GymNameExtendedTest {

    @Test
    @DisplayName("Should create GymName with valid value")
    void testCreateValidName() {
        GymName name = new GymName("Ultimate Fitness");
        assertNotNull(name);
    }

    @Test
    @DisplayName("Should throw exception for null name")
    void testNullNameThrowsException() {
        assertThrows(Exception.class, () -> new GymName(null));
    }

    @Test
    @DisplayName("Should store name value correctly")
    void testNameValueStorage() {
        String value = "Power Gym";
        GymName name = new GymName(value);
        assertEquals(value, name.getValue());
    }

    @Test
    @DisplayName("Should handle different gym name formats")
    void testDifferentNameFormats() {
        GymName name1 = new GymName("Simple Gym");
        GymName name2 = new GymName("24/7 Fitness Center");
        GymName name3 = new GymName("Elite Training Gym & Spa");
        assertNotNull(name1);
        assertNotNull(name2);
        assertNotNull(name3);
    }
}
