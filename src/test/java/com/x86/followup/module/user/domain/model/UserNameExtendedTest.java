package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserName Value Object Tests")
class UserNameExtendedTest {

    @Test
    @DisplayName("Should create UserName with valid value")
    void testCreateValidName() {
        UserName name = new UserName("John Doe");
        assertNotNull(name);
    }

    @Test
    @DisplayName("Should throw exception for null name")
    void testNullNameThrowsException() {
        assertThrows(Exception.class, () -> new UserName(null));
    }

    @Test
    @DisplayName("Should store name value correctly")
    void testNameValueStorage() {
        String value = "Jane Smith";
        UserName name = new UserName(value);
        assertEquals(value, name.getValue());
    }

    @Test
    @DisplayName("Should handle different name formats")
    void testDifferentNameFormats() {
        UserName name1 = new UserName("Maria");
        UserName name2 = new UserName("Juan Carlos Pérez");
        UserName name3 = new UserName("Ana María de los Ángeles García López");
        assertNotNull(name1);
        assertNotNull(name2);
        assertNotNull(name3);
    }
}
