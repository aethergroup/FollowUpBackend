package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserPhone Value Object Tests")
class UserPhoneTest {

    @Test
    @DisplayName("Should create UserPhone successfully")
    void testCreateUserPhoneSuccess() {
        UserPhone phone = new UserPhone("+57 3001234567");
        assertNotNull(phone);
        assertEquals("+57 3001234567", phone.getValue());
    }

    @Test
    @DisplayName("Should fail when phone is null")
    void testUserPhoneNull() {
        assertThrows(NullPointerException.class, () -> new UserPhone(null));
    }

    @Test
    @DisplayName("Should validate phone format")
    void testUserPhoneFormat() {
        UserPhone phone = new UserPhone("+1 2025550123");
        assertTrue(phone.getValue().startsWith("+"));
    }
}
