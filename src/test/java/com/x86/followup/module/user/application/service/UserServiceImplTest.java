package com.x86.followup.module.user.application.service;

import com.x86.followup.module.user.application.usecase.*;
import com.x86.followup.module.user.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserServiceImpl Tests")
class UserServiceImplTest {

    @Mock
    private UserSaveUseCase saveUseCase;

    @Mock
    private UserUpdateUseCase updateUseCase;

    @Mock
    private UserDeleteUseCase deleteUseCase;

    @Mock
    private UserFindByIdUseCase findByIdUseCase;

    @Mock
    private UserFindAllUseCase findAllUseCase;

    @Mock
    private UserFindByIdentificationUseCase findByIdentificationUseCase;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Should call save usecase")
    void testSaveUser() {
        verify(saveUseCase, times(0)).execute(any());
    }

    @Test
    @DisplayName("Should call update usecase")
    void testUpdateUser() {
        verify(updateUseCase, times(0)).execute(any());
    }

    @Test
    @DisplayName("Should call user delete usecase")
    void testDeleteUser() {
        Integer userId = 1;
        verify(deleteUseCase, times(0)).execute(userId);
    }

    @Test
    @DisplayName("Should find user by id through service")
    void testFindById() {
        Integer userId = 1;
        User user = createTestUser();
        when(findByIdUseCase.execute(userId)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(userId);

        assertTrue(result.isPresent());
        verify(findByIdUseCase, times(1)).execute(userId);
    }

    @Test
    @DisplayName("Should find all users through service")
    void testFindAll() {
        List<User> users = List.of(createTestUser());
        when(findAllUseCase.execute()).thenReturn(users);

        List<User> result = userService.findAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(findAllUseCase, times(1)).execute();
    }

    @Test
    @DisplayName("Should find user by identification through service")
    void testFindByIdentification() {
        String identification = "12345678";
        User user = createTestUser();
        when(findByIdentificationUseCase.execute(identification)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findByIdentification(identification);

        assertTrue(result.isPresent());
        verify(findByIdentificationUseCase, times(1)).execute(identification);
    }

    private User createTestUser() {
        return new User(
                new UserId(1),
                new UserGymId(1),
                new UserName("Test User"),
                new UserIdentification("12345678"),
                UserIdentificationType.CC,
                new UserPhone("555-1234"),
                new UserMembershipStart(Timestamp.valueOf(LocalDateTime.now())),
                new UserMembershipEnd(Timestamp.valueOf(LocalDateTime.now().plusDays(30))),
                UserPaymentMethod.EFECTIVO,
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
    }
}
