package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserMembershipEnd Value Object Tests")
class UserMembershipEndTest {

    @Test
    @DisplayName("Should create UserMembershipEnd successfully")
    void testCreateUserMembershipEndSuccess() {
        Timestamp future = new Timestamp(System.currentTimeMillis() + 86400000);
        UserMembershipEnd end = new UserMembershipEnd(future);
        assertNotNull(end);
        assertEquals(future, end.getValue());
    }

    @Test
    @DisplayName("Should store membership end date")
    void testUserMembershipEndValue() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() + 86400000);
        UserMembershipEnd end = new UserMembershipEnd(timestamp);
        assertTrue(end.getValue().getTime() > System.currentTimeMillis());
    }
}
