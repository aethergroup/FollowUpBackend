package com.x86.followup.module.user.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User Domain Model Tests")
class UserDomainModelTest {

    @Test
    @DisplayName("Should validate User model structure")
    void testUserModelStructure() {
        long now = System.currentTimeMillis();
        assertDoesNotThrow(() -> {
            User user = new User(
                    new UserId(1),
                    new UserGymId(1),
                    new UserName("Test User"),
                    new UserIdentification("ID123"),
                    UserIdentificationType.CC,
                    new UserPhone("+1 234"),
                    new UserMembershipStart(new Timestamp(now)),
                    new UserMembershipEnd(new Timestamp(now + 86400000)),
                    UserPaymentMethod.DIGITAL,
                    UserStatus.ACTIVE,
                    new UserCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
            );
            assertNotNull(user);
        });
    }

    @Test
    @DisplayName("Should handle User with all required fields")
    void testUserWithAllFields() {
        long now = System.currentTimeMillis();
        User user = new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("Complete User"),
                new UserIdentification("CC-123456789"),
                UserIdentificationType.CC,
                new UserPhone("+57 310 1234567"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 2592000000L)),
                UserPaymentMethod.EFECTIVO,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
        assertNotNull(user.getId());
        assertNotNull(user.getName());
        assertNotNull(user.getIdentification());
    }
}
