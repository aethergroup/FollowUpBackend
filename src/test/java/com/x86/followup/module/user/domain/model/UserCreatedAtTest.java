package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserCreatedAt Value Object Tests")
class UserCreatedAtTest {

    @Test
    @DisplayName("Should create UserCreatedAt successfully")
    void testCreateUserCreatedAtSuccess() {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        UserCreatedAt createdAt = new UserCreatedAt(now);
        assertNotNull(createdAt);
        assertEquals(now, createdAt.getValue());
    }

    @Test
    @DisplayName("Should store creation date")
    void testUserCreatedAtValue() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        UserCreatedAt createdAt = new UserCreatedAt(timestamp);
        assertTrue(createdAt.getValue().getTime() > 0);
    }
}
