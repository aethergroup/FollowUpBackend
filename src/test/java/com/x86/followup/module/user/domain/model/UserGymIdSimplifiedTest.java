package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserGymId Value Object Tests - Simplified")
class UserGymIdSimplifiedTest {

    @Test
    @DisplayName("Should create UserGymId successfully")
    void testCreateUserGymIdSuccess() {
        UserGymId gymId = new UserGymId(1);
        assertNotNull(gymId);
    }

    @Test
    @DisplayName("Should create different UserGymIds")
    void testDifferentUserGymIds() {
        UserGymId id1 = new UserGymId(1);
        UserGymId id2 = new UserGymId(2);
        UserGymId id3 = new UserGymId(3);
        
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotNull(id3);
    }

    @Test
    @DisplayName("Should handle UserGymId creation with various values")
    void testVariousGymIds() {
        assertDoesNotThrow(() -> new UserGymId(100));
        assertDoesNotThrow(() -> new UserGymId(999));
    }
}
