package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymPhone Value Object Tests")
class GymPhoneTest {

    @Test
    @DisplayName("Should create GymPhone successfully")
    void testCreateGymPhoneSuccess() {
        GymPhone phone = new GymPhone("+1 1234567890");
        assertNotNull(phone);
        assertEquals("+1 1234567890", phone.getValue());
    }

    @Test
    @DisplayName("Should fail when phone is null")
    void testGymPhoneNull() {
        assertThrows(NullPointerException.class, () -> new GymPhone(null));
    }

    @Test
    @DisplayName("Should validate phone format")
    void testGymPhoneFormat() {
        GymPhone phone = new GymPhone("+34 912345678");
        assertTrue(phone.getValue().startsWith("+"));
    }
}
