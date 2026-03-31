package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymId Value Object Tests")
class GymIdExtendedTest {

    @Test
    @DisplayName("Should create GymId with valid value")
    void testCreateValidId() {
        GymId id = new GymId(1);
        assertNotNull(id);
    }

    @Test
    @DisplayName("Should throw exception for null id")
    void testNullIdThrowsException() {
        assertThrows(Exception.class, () -> new GymId(null));
    }

    @Test
    @DisplayName("Should store id value correctly")
    void testIdValueStorage() {
        Integer value = 42;
        GymId id = new GymId(value);
        assertEquals(value, id.getValue());
    }

    @Test
    @DisplayName("Should handle different id values")
    void testDifferentIdValues() {
        GymId id1 = new GymId(1);
        GymId id2 = new GymId(100);
        GymId id3 = new GymId(999999);
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotNull(id3);
        assertEquals(1, id1.getValue());
        assertEquals(100, id2.getValue());
    }
}
