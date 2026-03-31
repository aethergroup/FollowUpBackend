package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserStatus Enum Tests")
class UserStatusTest {

    @Test
    @DisplayName("Should have ACTIVE status")
    void testActiveStatus() {
        assertEquals(UserStatus.ACTIVE, UserStatus.ACTIVE);
    }

    @Test
    @DisplayName("Should have IN_PENDING status")
    void testInPendingStatus() {
        assertNotNull(UserStatus.IN_PENDING);
    }

    @Test
    @DisplayName("Should have INACTIVE status")
    void testInactiveStatus() {
        assertEquals(UserStatus.INACTIVE, UserStatus.INACTIVE);
    }

    @Test
    @DisplayName("Should have all statuses")
    void testAllStatuses() {
        UserStatus[] statuses = UserStatus.values();
        assertTrue(statuses.length >= 3);
    }

    @Test
    @DisplayName("Should recognize different statuses")
    void testDifferentStatuses() {
        assertNotEquals(UserStatus.ACTIVE, UserStatus.INACTIVE);
    }
}
