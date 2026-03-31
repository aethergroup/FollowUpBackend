package com.x86.followup.module.user.application.service;

import com.x86.followup.module.user.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("UserService Integration Tests")
class UserServiceIntegrationTest {

    @Test
    @DisplayName("Should create complete User object")
    void testUserCreation() {
        long now = System.currentTimeMillis();
        User user = new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("Integration Test"),
                new UserIdentification("1234567"),
                UserIdentificationType.CC,
                new UserPhone("+1 789"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.DIGITAL,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );

        assertNotNull(user);
        assertEquals("Integration Test", user.getName().getValue());
    }

    @Test
    @DisplayName("Should handle User with different payment methods")
    void testUserWithDifferentPaymentMethods() {
        long now = System.currentTimeMillis();
        
        User userDigital = new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("Digital User"),
                new UserIdentification("111"),
                UserIdentificationType.CC,
                new UserPhone("+1 111"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.DIGITAL,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );

        User userEfectivo = new User(
                new UserId(2),
                new UserGymId(1),
                new UserName("Efectivo User"),
                new UserIdentification("222"),
                UserIdentificationType.TI,
                new UserPhone("+1 222"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.EFECTIVO,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );

        assertEquals(UserPaymentMethod.DIGITAL, userDigital.getPaymentMethod());
        assertEquals(UserPaymentMethod.EFECTIVO, userEfectivo.getPaymentMethod());
    }
}
