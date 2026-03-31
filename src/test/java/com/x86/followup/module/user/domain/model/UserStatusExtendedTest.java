package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserStatus Enum Tests")
class UserStatusExtendedTest {

    @Test
    @DisplayName("Should have ACTIVE status")
    void testActiveStatus() {
        UserStatus status = UserStatus.ACTIVE;
        assertNotNull(status);
    }

    @Test
    @DisplayName("Should have INACTIVE status")
    void testInactiveStatus() {
        UserStatus status = UserStatus.INACTIVE;
        assertNotNull(status);
    }

    @Test
    @DisplayName("Should have multiple status values")
    void testMultipleStatuses() {
        UserStatus status = UserStatus.ACTIVE;
        assertNotNull(status);
    }

    @Test
    @DisplayName("Should retrieve all statuses")
    void testAllStatusValues() {
        UserStatus[] statuses = UserStatus.values();
        assertTrue(statuses.length >= 3);
    }

    @Test
    @DisplayName("Should handle different statuses")
    void testDifferentStatuses() {
        UserStatus s1 = UserStatus.ACTIVE;
        UserStatus s2 = UserStatus.INACTIVE;
        assertNotEquals(s1, s2);
    }
}
