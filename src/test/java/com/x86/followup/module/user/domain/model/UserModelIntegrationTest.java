package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User Model Integration Tests")
class UserModelIntegrationTest {

    @Test
    @DisplayName("Should create complete User with all fields")
    void testCreateCompleteUser() {
        long now = System.currentTimeMillis();
        User user = new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("John Doe"),
                new UserIdentification("123456"),
                UserIdentificationType.CC,
                new UserPhone("+57 3001234567"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 2592000000L)),
                UserPaymentMethod.DIGITAL,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );

        assertNotNull(user);
        assertEquals("John Doe", user.getName().getValue());
        assertTrue(user.isSubscriptionActive());
    }

    @Test
    @DisplayName("Should create User with null ID")
    void testCreateUserWithNullId() {
        long now = System.currentTimeMillis();
        User user = new User(
                null,
                new UserGymId(1),
                new UserName("Jane Doe"),
                new UserIdentification("654321"),
                UserIdentificationType.TI,
                new UserPhone("+57 3009876543"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 2592000000L)),
                UserPaymentMethod.EFECTIVO,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );

        assertNotNull(user);
        assertNull(user.getId());
    }

    @Test
    @DisplayName("Should validate users with different identification types")
    void testUserWithDifferentIdentificationTypes() {
        long now = System.currentTimeMillis();
        
        User userCC = new User(null, new UserGymId(1), new UserName("User CC"),
                new UserIdentification("111111"), UserIdentificationType.CC,
                new UserPhone("+1 555"), new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.DIGITAL, UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(LocalDateTime.now())));

        User userTI = new User(null, new UserGymId(1), new UserName("User TI"),
                new UserIdentification("222222"), UserIdentificationType.TI,
                new UserPhone("+1 666"), new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.DIGITAL, UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(LocalDateTime.now())));

        assertEquals(UserIdentificationType.CC, userCC.getIdentificationType());
        assertEquals(UserIdentificationType.TI, userTI.getIdentificationType());
    }
}
