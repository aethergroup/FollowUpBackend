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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserUpdateUseCase Tests")
class UserUpdateUseCaseTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserUpdateUseCase userUpdateUseCase;

    private User createTestUser() {
        return new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("Updated User"),
                new UserIdentification("87654321"),
                UserIdentificationType.TI,
                new UserPhone("+57 3001234567"),
                new UserMembershipStart(new Timestamp(System.currentTimeMillis())),
                new UserMembershipEnd(new Timestamp(System.currentTimeMillis() + 86400000)),
                UserPaymentMethod.EFECTIVO,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(java.time.LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should update user successfully")
    void testUpdateUserSuccess() {
        User user = createTestUser();
        userUpdateUseCase.execute(user);
        verify(repository, times(1)).update(user);
    }

    @Test
    @DisplayName("Should call repository update method")
    void testUpdateUsesRepository() {
        User user = createTestUser();
        userUpdateUseCase.execute(user);
        verify(repository).update(any(User.class));
    }
}
