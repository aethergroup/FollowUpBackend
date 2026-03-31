package com.x86.followup.module.gym.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GymEmail Value Object Tests")
class GymEmailTest {

    @Test
    @DisplayName("Should create GymEmail with valid value")
    void testCreateValidEmail() {
        GymEmail email = new GymEmail("test@example.com");
        assertNotNull(email);
    }

    @Test
    @DisplayName("Should throw exception for null email")
    void testNullEmailThrowsException() {
        assertThrows(Exception.class, () -> new GymEmail(null));
    }

    @Test
    @DisplayName("Should store email value correctly")
    void testEmailValueStorage() {
        String value = "contact@gym.com";
        GymEmail email = new GymEmail(value);
        assertEquals(value, email.getValue());
    }

    @Test
    @DisplayName("Should handle different email formats")
    void testDifferentEmailFormats() {
        GymEmail email1 = new GymEmail("simple@domain.com");
        GymEmail email2 = new GymEmail("complex.name+tag@sub.domain.co.uk");
        assertNotNull(email1);
        assertNotNull(email2);
    }
}
