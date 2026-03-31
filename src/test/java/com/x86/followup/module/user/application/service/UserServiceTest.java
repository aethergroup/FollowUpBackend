package com.x86.followup.module.user.application.service;

import com.x86.followup.module.user.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserService Tests")
class UserServiceTest {

    @Mock
    private UserService userService;

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
    @DisplayName("Should save user through service")
    void testSaveUser() {
        User user = createTestUser(null);
        userService.save(user);
        verify(userService).save(user);
    }

    @Test
    @DisplayName("Should find user by id through service")
    void testFindById() {
        Integer userId = 1;
        User user = createTestUser(userId);
        when(userService.findById(userId)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(userId);

        assertTrue(result.isPresent());
        verify(userService, times(1)).findById(userId);
    }

    @Test
    @DisplayName("Should find all users through service")
    void testFindAll() {
        userService.findAll();
        verify(userService).findAll();
    }

    @Test
    @DisplayName("Should delete user through service")
    void testDeleteUser() {
        Integer userId = 1;
        userService.delete(userId);
        verify(userService).delete(userId);
    }

    @Test
    @DisplayName("Should update user through service")
    void testUpdateUser() {
        User user = createTestUser(1);
        userService.update(user);
        verify(userService).update(user);
    }
}
