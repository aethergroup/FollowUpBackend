package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserMembershipStart Value Object Tests")
class UserMembershipStartTest {

    @Test
    @DisplayName("Should create UserMembershipStart with valid timestamp")
    void testCreateValidTimestamp() {
        Timestamp start = Timestamp.valueOf(LocalDateTime.now());
        UserMembershipStart membershipStart = new UserMembershipStart(start);
        assertNotNull(membershipStart);
    }

    @Test
    @DisplayName("Should throw exception for null timestamp")
    void testNullTimestampThrowsException() {
        assertThrows(Exception.class, () -> new UserMembershipStart(null));
    }

    @Test
    @DisplayName("Should handle different membership start dates")
    void testDifferentDates() {
        Timestamp today = Timestamp.valueOf(LocalDateTime.now());
        Timestamp tomorrow = Timestamp.valueOf(LocalDateTime.now().plusDays(1));
        UserMembershipStart ms1 = new UserMembershipStart(today);
        UserMembershipStart ms2 = new UserMembershipStart(tomorrow);
        assertNotNull(ms1);
        assertNotNull(ms2);
    }
}
