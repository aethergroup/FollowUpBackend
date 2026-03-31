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
@DisplayName("UserFindByIdentificationUseCase Tests")
class UserFindByIdentificationUseCaseTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserFindByIdentificationUseCase userFindByIdentificationUseCase;

    private User createTestUser(String identification) {
        return new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("Test User"),
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
    @DisplayName("Should find user by identification successfully")
    void testFindByIdentificationSuccess() {
        String identification = "12345678";
        User user = createTestUser(identification);
        when(repository.findByIdentification(identification)).thenReturn(Optional.of(user));

        Optional<User> result = userFindByIdentificationUseCase.execute(identification);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());
        verify(repository, times(1)).findByIdentification(identification);
    }

    @Test
    @DisplayName("Should return empty Optional when user not found by identification")
    void testFindByIdentificationNotFound() {
        String identification = "99999999";
        when(repository.findByIdentification(identification)).thenReturn(Optional.empty());

        Optional<User> result = userFindByIdentificationUseCase.execute(identification);

        assertTrue(result.isEmpty());
    }
}
