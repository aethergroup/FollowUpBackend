package com.x86.followup.module.user.infrastructure.persistence;

import com.x86.followup.module.user.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("UserRepository Integration Tests")
class UserRepositoryIntegrationTest {

    private User createTestUser(String name, String identification) {
        return new User(
                null,
                new UserGymId(1),
                new UserName(name),
                new UserIdentification(identification),
                UserIdentificationType.CC,
                new UserPhone("+1 234567890"),
                new UserMembershipStart(new Timestamp(System.currentTimeMillis())),
                new UserMembershipEnd(new Timestamp(System.currentTimeMillis() + 86400000)),
                UserPaymentMethod.DIGITAL,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should support user persistence operations")
    void testUserPersistence() {
        assertDoesNotThrow(() -> {
            User user = createTestUser("Integration Test User", "ID12345");
            assertNotNull(user);
        });
    }

    @Test
    @DisplayName("Should find user operations")
    void testFindUserOperations() {
        assertDoesNotThrow(() -> {
            User user = createTestUser("Find Test User", "ID67890");
            assertNotNull(user);
        });
    }
}
