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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserFindByIdUseCase Tests")
class UserFindByIdUseCaseTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserFindByIdUseCase userFindByIdUseCase;

    private User createTestUser(Integer id) {
        return new User(
                new UserId(id),
                new UserGymId(1),
                new UserName("Test User"),
                new UserIdentification("12345678"),
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
    @DisplayName("Should find user by id successfully")
    void testFindByIdSuccess() {
        Integer userId = 1;
        User user = createTestUser(userId);
        when(repository.findById(any(UserId.class))).thenReturn(Optional.of(user));

        Optional<User> result = userFindByIdUseCase.execute(userId);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());
        verify(repository, times(1)).findById(any(UserId.class));
    }

    @Test
    @DisplayName("Should return empty Optional when user not found")
    void testFindByIdNotFound() {
        Integer userId = 999;
        when(repository.findById(any(UserId.class))).thenReturn(Optional.empty());

        Optional<User> result = userFindByIdUseCase.execute(userId);

        assertTrue(result.isEmpty());
    }
}
