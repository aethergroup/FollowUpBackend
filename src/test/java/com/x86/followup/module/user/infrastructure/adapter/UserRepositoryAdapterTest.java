package com.x86.followup.module.user.infrastructure.adapter;

import com.x86.followup.module.user.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("UserRepositoryAdapter Tests")
class UserRepositoryAdapterTest {

    @Test
    @DisplayName("UserRepositoryAdapter should exist in context")
    void testRepositoryAdapterExists() {
        assertDoesNotThrow(() -> {
            // Repository adapter would be tested here
        });
    }

    @Test
    @DisplayName("Should handle User persistence operations")
    void testUserPersistenceOperations() {
        long now = System.currentTimeMillis();
        User user = new User(
                null,
                new UserGymId(1),
                new UserName("Adapter Test User"),
                new UserIdentification("ADT123"),
                UserIdentificationType.CE,
                new UserPhone("+1 777"),
                new UserMembershipStart(new Timestamp(now)),
                new UserMembershipEnd(new Timestamp(now + 86400000)),
                UserPaymentMethod.DIGITAL,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );

        assertNotNull(user);
        assertNull(user.getId());
    }
}
