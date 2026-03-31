package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymAddress Value Object Tests")
class GymAddressExtendedTest {

    @Test
    @DisplayName("Should create GymAddress with valid value")
    void testCreateValidAddress() {
        GymAddress address = new GymAddress("123 Main St, City, State 12345");
        assertNotNull(address);
    }

    @Test
    @DisplayName("Should throw exception for null address")
    void testNullAddressThrowsException() {
        assertThrows(Exception.class, () -> new GymAddress(null));
    }

    @Test
    @DisplayName("Should store address value correctly")
    void testAddressValueStorage() {
        String value = "456 Park Ave, Downtown";
        GymAddress address = new GymAddress(value);
        assertEquals(value, address.getValue());
    }

    @Test
    @DisplayName("Should handle different address formats")
    void testDifferentAddressFormats() {
        GymAddress address1 = new GymAddress("Street Address");
        GymAddress address2 = new GymAddress("123 Main St, Apt 4B, New York, NY 10001");
        GymAddress address3 = new GymAddress("Calle Principal 789, Barrio Centro");
        assertNotNull(address1);
        assertNotNull(address2);
        assertNotNull(address3);
    }
}
