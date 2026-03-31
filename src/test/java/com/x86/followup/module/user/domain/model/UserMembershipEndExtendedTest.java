package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserMembershipEnd Value Object Tests")
class UserMembershipEndExtendedTest {

    @Test
    @DisplayName("Should create UserMembershipEnd with valid timestamp")
    void testCreateValidTimestamp() {
        Timestamp end = Timestamp.valueOf(LocalDateTime.now().plusMonths(1));
        UserMembershipEnd membershipEnd = new UserMembershipEnd(end);
        assertNotNull(membershipEnd);
    }

    @Test
    @DisplayName("Should throw exception for null timestamp")
    void testNullTimestampThrowsException() {
        assertThrows(Exception.class, () -> new UserMembershipEnd(null));
    }

    @Test
    @DisplayName("Should store timestamp value correctly")
    void testTimestampValueStorage() {
        Timestamp end = Timestamp.valueOf(LocalDateTime.now().plusMonths(1));
        UserMembershipEnd membershipEnd = new UserMembershipEnd(end);
        assertEquals(end, membershipEnd.getValue());
    }

    @Test
    @DisplayName("Should handle different membership end dates")
    void testDifferentDates() {
        Timestamp oneMonth = Timestamp.valueOf(LocalDateTime.now().plusMonths(1));
        Timestamp threeMonths = Timestamp.valueOf(LocalDateTime.now().plusMonths(3));
        UserMembershipEnd me1 = new UserMembershipEnd(oneMonth);
        UserMembershipEnd me2 = new UserMembershipEnd(threeMonths);
        assertNotNull(me1);
        assertNotNull(me2);
    }
}
