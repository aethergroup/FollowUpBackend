package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymAddress Value Object Tests")
class GymAddressTest {

    @Test
    @DisplayName("Should create GymAddress successfully")
    void testCreateGymAddressSuccess() {
        GymAddress address = new GymAddress("123 Main Street, City");
        assertNotNull(address);
        assertEquals("123 Main Street, City", address.getValue());
    }

    @Test
    @DisplayName("Should fail when address is null")
    void testGymAddressNull() {
        assertThrows(NullPointerException.class, () -> new GymAddress(null));
    }

    @Test
    @DisplayName("Should store address value")
    void testGymAddressValue() {
        GymAddress address = new GymAddress("456 Elm Street");
        assertTrue(address.getValue().contains("Street"));
    }
}
