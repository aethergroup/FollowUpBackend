package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserId Value Object Tests")
class UserIdTest {

    @Test
    @DisplayName("Should create UserId successfully")
    void testCreateUserIdSuccess() {
        UserId userId = new UserId(1);
        assertNotNull(userId);
        assertEquals(1, userId.getValue());
    }

    @Test
    @DisplayName("Should handle null UserId")
    void testCreateUserIdNull() {
        UserId userId = new UserId(null);
        assertNotNull(userId);
        assertNull(userId.getValue());
    }

    @Test
    @DisplayName("Should compare UserIds")
    void testCompareUserIds() {
        UserId id1 = new UserId(1);
        UserId id2 = new UserId(1);
        UserId id3 = new UserId(2);
        
        assertEquals(id1.getValue(), id2.getValue());
        assertNotEquals(id1.getValue(), id3.getValue());
    }
}
