package com.x86.followup.module.gym.infrastructure.controller;

import com.x86.followup.module.gym.application.service.GymService;
import com.x86.followup.module.gym.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymController Tests")
class GymControllerTest {

    @Mock
    private GymService gymService;

    @InjectMocks
    private GymController gymController;

    private MockMvc mockMvc;

    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(gymController).build();
    }

    private Gym createTestGym(Integer id) {
        return new Gym(
                new GymId(id),
                new GymName("Test Gym"),
                new GymEmail("test@gym.com"),
                new GymPhone("+1 234567890"),
                new GymAddress("123 Main St"),
                new GymPasswordHash("hashed_password"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should create gym successfully")
    void testCreateGymSuccess() throws Exception {
        setUp();
        doNothing().when(gymService).save(any(Gym.class));

        mockMvc.perform(post("/api/gyms"))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should retrieve all gyms")
    void testGetAllGyms() throws Exception {
        setUp();
        List<Gym> gyms = List.of(createTestGym(1), createTestGym(2));
        when(gymService.findAll()).thenReturn(gyms);

        mockMvc.perform(get("/api/gyms"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should retrieve gym by id")
    void testGetGymById() throws Exception {
        setUp();
        Gym gym = createTestGym(1);
        when(gymService.findById(1)).thenReturn(Optional.of(gym));

        mockMvc.perform(get("/api/gyms/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should delete gym successfully")
    void testDeleteGym() throws Exception {
        setUp();
        doNothing().when(gymService).delete(1);

        mockMvc.perform(delete("/api/gyms/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Should update gym successfully")
    void testUpdateGym() throws Exception {
        setUp();
        doNothing().when(gymService).update(any(Gym.class));

        mockMvc.perform(put("/api/gyms/1"))
                .andExpect(status().isOk());
    }
}
