package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserId Value Object Tests")
class UserIdExtendedTest {

    @Test
    @DisplayName("Should create UserId with valid value")
    void testCreateValidId() {
        UserId id = new UserId(1);
        assertNotNull(id);
    }

    @Test
    @DisplayName("Should throw exception for null id")
    void testNullIdThrowsException() {
        assertThrows(Exception.class, () -> new UserId(null));
    }

    @Test
    @DisplayName("Should store id value correctly")
    void testIdValueStorage() {
        Integer value = 42;
        UserId id = new UserId(value);
        assertEquals(value, id.getValue());
    }

    @Test
    @DisplayName("Should handle different id values")
    void testDifferentIdValues() {
        UserId id1 = new UserId(1);
        UserId id2 = new UserId(100);
        UserId id3 = new UserId(999999);
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotNull(id3);
        assertEquals(1, id1.getValue());
        assertEquals(100, id2.getValue());
    }
}
