package com.x86.followup.module.user.infrastructure.controller;

import com.x86.followup.module.user.application.service.UserService;
import com.x86.followup.module.user.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserController Tests")
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

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
    @DisplayName("Should create user successfully")
    void testCreateUserSuccess() throws Exception {
        setUp();
        doNothing().when(userService).save(any(User.class));

        mockMvc.perform(post("/api/users"))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should retrieve all users")
    void testGetAllUsers() throws Exception {
        setUp();
        List<User> users = List.of(createTestUser(1), createTestUser(2));
        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should retrieve user by id")
    void testGetUserById() throws Exception {
        setUp();
        User user = createTestUser(1);
        when(userService.findById(1)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should delete user successfully")
    void testDeleteUser() throws Exception {
        setUp();
        doNothing().when(userService).delete(1);

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Should update user successfully")
    void testUpdateUser() throws Exception {
        setUp();
        doNothing().when(userService).update(any(User.class));

        mockMvc.perform(put("/api/users/1"))
                .andExpect(status().isOk());
    }
}
