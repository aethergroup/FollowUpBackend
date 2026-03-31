package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User Model Tests")
class UserTest {

    private User createValidUser() {
        return new User(
                null,
                new UserGymId(1),
                new UserName("John Doe"),
                new UserIdentification("12345678"),
                UserIdentificationType.CC,
                new UserPhone("+1 1234567890"),
                new UserMembershipStart(new Timestamp(System.currentTimeMillis())),
                new UserMembershipEnd(new Timestamp(System.currentTimeMillis() + 86400000)),
                UserPaymentMethod.DIGITAL,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should create user successfully")
    void testCreateUserSuccess() {
        User user = createValidUser();
        assertNotNull(user);
        assertEquals("John Doe", user.getName().getValue());
    }

    @Test
    @DisplayName("Should fail when name is null")
    void testUserNameNull() {
        assertThrows(NullPointerException.class, () ->
                new User(
                        null,
                        new UserGymId(1),
                        null,
                        new UserIdentification("12345678"),
                        UserIdentificationType.CC,
                        new UserPhone("+1 1234567890"),
                        new UserMembershipStart(new Timestamp(System.currentTimeMillis())),
                        new UserMembershipEnd(new Timestamp(System.currentTimeMillis() + 86400000)),
                        UserPaymentMethod.DIGITAL,
                        UserStatus.ACTIVE,
                        new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
                )
        );
    }

    @Test
    @DisplayName("Should fail when identification is null")
    void testUserIdentificationNull() {
        assertThrows(NullPointerException.class, () ->
                new User(
                        null,
                        new UserGymId(1),
                        new UserName("John Doe"),
                        null,
                        UserIdentificationType.CC,
                        new UserPhone("+1 1234567890"),
                        new UserMembershipStart(new Timestamp(System.currentTimeMillis())),
                        new UserMembershipEnd(new Timestamp(System.currentTimeMillis() + 86400000)),
                        UserPaymentMethod.DIGITAL,
                        UserStatus.ACTIVE,
                        new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
                )
        );
    }

    @Test
    @DisplayName("Should fail when phone is null")
    void testUserPhoneNull() {
        assertThrows(NullPointerException.class, () ->
                new User(
                        null,
                        new UserGymId(1),
                        new UserName("John Doe"),
                        new UserIdentification("12345678"),
                        UserIdentificationType.CC,
                        null,
                        new UserMembershipStart(new Timestamp(System.currentTimeMillis())),
                        new UserMembershipEnd(new Timestamp(System.currentTimeMillis() + 86400000)),
                        UserPaymentMethod.DIGITAL,
                        UserStatus.ACTIVE,
                        new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
                )
        );
    }

    @Test
    @DisplayName("Should fail when membership end is before start")
    void testMembershipDateValidation() {
        long now = System.currentTimeMillis();
        assertThrows(IllegalArgumentException.class, () ->
                new User(
                        null,
                        new UserGymId(1),
                        new UserName("John Doe"),
                        new UserIdentification("12345678"),
                        UserIdentificationType.CC,
                        new UserPhone("+1 1234567890"),
                        new UserMembershipStart(new Timestamp(now + 86400000)),
                        new UserMembershipEnd(new Timestamp(now)),
                        UserPaymentMethod.DIGITAL,
                        UserStatus.ACTIVE,
                        new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
                )
        );
    }

    @Test
    @DisplayName("Should have active subscription")
    void testIsSubscriptionActive() {
        User user = new User(
                null,
                new UserGymId(1),
                new UserName("John Doe"),
                new UserIdentification("12345678"),
                UserIdentificationType.CC,
                new UserPhone("+1 1234567890"),
                new UserMembershipStart(new Timestamp(System.currentTimeMillis())),
                new UserMembershipEnd(new Timestamp(System.currentTimeMillis() + 86400000)),
                UserPaymentMethod.DIGITAL,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );
        
        assertTrue(user.isSubscriptionActive());
    }
}
