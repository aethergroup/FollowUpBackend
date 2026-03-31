package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserMembershipStart Value Object Tests")
class UserMembershipStartTest {

    @Test
    @DisplayName("Should create UserMembershipStart successfully")
    void testCreateUserMembershipStartSuccess() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        UserMembershipStart start = new UserMembershipStart(now);
        assertNotNull(start);
        assertEquals(now, start.getValue());
    }

    @Test
    @DisplayName("Should store membership start date")
    void testUserMembershipStartValue() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        UserMembershipStart start = new UserMembershipStart(timestamp);
        assertTrue(start.getValue().getTime() > 0);
    }
}
