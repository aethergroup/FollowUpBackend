package com.x86.followup.module.user.application.service;

import com.x86.followup.module.user.domain.model.*;
import com.x86.followup.module.user.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserService Extended Tests")
class UserServiceExtendedTest {

    @Mock
    private UserRepository repository;

    @Test
    @DisplayName("Should create valid User for service operations")
    void testCreateUserForServiceOps() {
        long now = System.currentTimeMillis();
        User user = new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("Service Test"),
                new UserIdentification("SVC123"),
                UserIdentificationType.CC,
                new UserPhone("+1 999"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.DIGITAL,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );

        assertNotNull(user);
        assertNotNull(user.getId());
        assertNotNull(user.getName());
        assertNotNull(user.getIdentification());
    }

    @Test
    @DisplayName("Should handle multiple Users")
    void testMultipleUsers() {
        long now = System.currentTimeMillis();
        User user1 = new User(new UserId(1), new UserGymId(1), new UserName("User1"),
                new UserIdentification("ID1"), UserIdentificationType.CC, new UserPhone("+1 111"),
                new UserMembershipStart(new Timestamp(now)), new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.DIGITAL, UserStatus.ACTIVE, new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now())));

        User user2 = new User(new UserId(2), new UserGymId(1), new UserName("User2"),
                new UserIdentification("ID2"), UserIdentificationType.TI, new UserPhone("+1 222"),
                new UserMembershipStart(new Timestamp(now)), new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.EFECTIVO, UserStatus.ACTIVE, new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now())));

        assertNotNull(user1);
        assertNotNull(user2);
    }
}
