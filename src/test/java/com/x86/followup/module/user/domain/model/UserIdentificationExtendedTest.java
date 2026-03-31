package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserIdentification Value Object Tests")
class UserIdentificationExtendedTest {

    @Test
    @DisplayName("Should create UserIdentification with valid value")
    void testCreateValidIdentification() {
        UserIdentification identification = new UserIdentification("123456789");
        assertNotNull(identification);
    }

    @Test
    @DisplayName("Should throw exception for null identification")
    void testNullIdentificationThrowsException() {
        assertThrows(Exception.class, () -> new UserIdentification(null));
    }

    @Test
    @DisplayName("Should store identification value correctly")
    void testIdentificationValueStorage() {
        String value = "CC-123456789";
        UserIdentification identification = new UserIdentification(value);
        assertEquals(value, identification.getValue());
    }

    @Test
    @DisplayName("Should handle different identification formats")
    void testDifferentIdentificationFormats() {
        UserIdentification id1 = new UserIdentification("12345");
        UserIdentification id2 = new UserIdentification("ID-98765432");
        UserIdentification id3 = new UserIdentification("XX-1234567890");
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotNull(id3);
    }
}
