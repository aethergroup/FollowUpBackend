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
@DisplayName("UserSaveUseCase Tests")
class UserSaveUseCaseTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserSaveUseCase userSaveUseCase;

    private User createTestUser() {
        return new User(
                null,
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
    @DisplayName("Should save user successfully")
    void testSaveUserSuccess() {
        User user = createTestUser();
        userSaveUseCase.execute(user);
        verify(repository, times(1)).save(user);
    }

    @Test
    @DisplayName("Should call repository save method")
    void testSaveUsesRepository() {
        User user = createTestUser();
        userSaveUseCase.execute(user);
        verify(repository).save(any(User.class));
    }
}
