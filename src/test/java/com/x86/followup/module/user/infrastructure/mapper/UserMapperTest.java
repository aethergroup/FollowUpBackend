package com.x86.followup.module.user.infrastructure.mapper;

import com.x86.followup.module.user.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("UserMapper Tests")
class UserMapperTest {

    @Test
    @DisplayName("Should create valid User for mapping")
    void testUserForMapping() {
        long now = System.currentTimeMillis();
        User user = new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("Mapper Test"),
                new UserIdentification("MAP123"),
                UserIdentificationType.CC,
                new UserPhone("+1 999"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.DIGITAL,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );

        assertNotNull(user);
        assertEquals("Mapper Test", user.getName().getValue());
    }

    @Test
    @DisplayName("Should handle User with all fields for DTO conversion")
    void testUserFieldsForDtoConversion() {
        long now = System.currentTimeMillis();
        User user = new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("Complete User"),
                new UserIdentification("COMPLETE123"),
                UserIdentificationType.TI,
                new UserPhone("+57 3001234567"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 2592000000L)),
                UserPaymentMethod.EFECTIVO,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );

        assertTrue(user.getId().getValue() > 0);
        assertTrue(user.getPhone().getValue().startsWith("+"));
        assertEquals(UserPaymentMethod.EFECTIVO, user.getPaymentMethod());
    }
}
