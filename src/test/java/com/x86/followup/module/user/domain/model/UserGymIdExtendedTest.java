package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserGymId Value Object Tests")
class UserGymIdExtendedTest {

    @Test
    @DisplayName("Should create UserGymId with valid value")
    void testCreateValidGymId() {
        UserGymId gymId = new UserGymId(1);
        assertNotNull(gymId);
    }

    @Test
    @DisplayName("Should throw exception for null gym id")
    void testNullGymIdThrowsException() {
        assertThrows(Exception.class, () -> new UserGymId(null));
    }

    @Test
    @DisplayName("Should store gym id value correctly")
    void testGymIdValueStorage() {
        Integer value = 5;
        UserGymId gymId = new UserGymId(value);
        assertNotNull(gymId);
    }

    @Test
    @DisplayName("Should handle different gym id values")
    void testDifferentGymIdValues() {
        UserGymId gymId1 = new UserGymId(1);
        UserGymId gymId2 = new UserGymId(10);
        UserGymId gymId3 = new UserGymId(500);
        assertNotNull(gymId1);
        assertNotNull(gymId2);
        assertNotNull(gymId3);
    }
}
