package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymId Value Object Tests")
class GymIdTest {

    @Test
    @DisplayName("Should create GymId successfully")
    void testCreateGymIdSuccess() {
        GymId gymId = new GymId(1);
        assertNotNull(gymId);
        assertEquals(1, gymId.getValue());
    }

    @Test
    @DisplayName("Should handle null GymId")
    void testCreateGymIdNull() {
        GymId gymId = new GymId(null);
        assertNotNull(gymId);
        assertNull(gymId.getValue());
    }

    @Test
    @DisplayName("Should compare GymIds")
    void testCompareGymIds() {
        GymId id1 = new GymId(1);
        GymId id2 = new GymId(1);
        GymId id3 = new GymId(2);
        
        assertEquals(id1.getValue(), id2.getValue());
        assertNotEquals(id1.getValue(), id3.getValue());
    }
}
