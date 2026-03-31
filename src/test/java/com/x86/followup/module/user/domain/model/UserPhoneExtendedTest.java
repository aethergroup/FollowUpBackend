package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserPhone Value Object Tests")
class UserPhoneExtendedTest {

    @Test
    @DisplayName("Should create UserPhone with valid value")
    void testCreateValidPhone() {
        UserPhone phone = new UserPhone("+57 310 1234567");
        assertNotNull(phone);
    }

    @Test
    @DisplayName("Should throw exception for null phone")
    void testNullPhoneThrowsException() {
        assertThrows(Exception.class, () -> new UserPhone(null));
    }

    @Test
    @DisplayName("Should store phone value correctly")
    void testPhoneValueStorage() {
        String value = "+1 (555) 123-4567";
        UserPhone phone = new UserPhone(value);
        assertEquals(value, phone.getValue());
    }

    @Test
    @DisplayName("Should handle different phone formats")
    void testDifferentPhoneFormats() {
        UserPhone phone1 = new UserPhone("+1 123");
        UserPhone phone2 = new UserPhone("+57 3001234567");
        UserPhone phone3 = new UserPhone("+34 91 1234567");
        assertNotNull(phone1);
        assertNotNull(phone2);
        assertNotNull(phone3);
    }
}
