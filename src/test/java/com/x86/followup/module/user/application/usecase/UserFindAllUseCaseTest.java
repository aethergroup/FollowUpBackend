package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.model.*;
import com.x86.followup.module.user.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserFindAllUseCase Tests")
class UserFindAllUseCaseTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserFindAllUseCase userFindAllUseCase;

    private User createTestUser(Integer id, String name) {
        return new User(
                new UserId(id),
                new UserGymId(1),
                new UserName(name),
                new UserIdentification("ID" + id),
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
    @DisplayName("Should find all users successfully")
    void testFindAllSuccess() {
        List<User> users = List.of(
                createTestUser(1, "User 1"),
                createTestUser(2, "User 2"),
                createTestUser(3, "User 3")
        );
        when(repository.findAll()).thenReturn(users);

        List<User> result = userFindAllUseCase.execute();

        assertNotNull(result);
        assertEquals(3, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should return empty list when no users exist")
    void testFindAllEmpty() {
        when(repository.findAll()).thenReturn(List.of());

        List<User> result = userFindAllUseCase.execute();

        assertTrue(result.isEmpty());
    }
}
