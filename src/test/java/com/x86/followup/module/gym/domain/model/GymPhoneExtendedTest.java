package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymPhone Value Object Tests")
class GymPhoneTest {

    @Test
    @DisplayName("Should create GymPhone with valid value")
    void testCreateValidPhone() {
        GymPhone phone = new GymPhone("+1 234 567 8900");
        assertNotNull(phone);
    }

    @Test
    @DisplayName("Should throw exception for null phone")
    void testNullPhoneThrowsException() {
        assertThrows(Exception.class, () -> new GymPhone(null));
    }

    @Test
    @DisplayName("Should store phone value correctly")
    void testPhoneValueStorage() {
        String value = "+1 5551234567";
        GymPhone phone = new GymPhone(value);
        assertEquals(value, phone.getValue());
    }

    @Test
    @DisplayName("Should handle international phone numbers")
    void testInternationalPhoneNumbers() {
        GymPhone phone1 = new GymPhone("+1 123");
        GymPhone phone2 = new GymPhone("+57 312 1234567");
        GymPhone phone3 = new GymPhone("+44 20 7946 0958");
        assertNotNull(phone1);
        assertNotNull(phone2);
        assertNotNull(phone3);
    }
}
