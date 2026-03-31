package com.x86.followup.module.gym.application.service;

import com.x86.followup.module.gym.domain.model.*;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymService Extended Tests")
class GymServiceExtendedTest {

    @Mock
    private GymRepository repository;

    @Test
    @DisplayName("Should create valid Gym for service operations")
    void testCreateGymForServiceOps() {
        Gym gym = new Gym(
                new GymId(1),
                new GymName("Service Test"),
                new GymEmail("service@test.com"),
                new GymPhone("+1 999"),
                new GymAddress("Test Street"),
                new GymPasswordHash("hashed"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );

        assertNotNull(gym);
        assertNotNull(gym.getId());
        assertNotNull(gym.getName());
        assertNotNull(gym.getEmail());
    }

    @Test
    @DisplayName("Should handle multiple Gyms")
    void testMultipleGyms() {
        Gym gym1 = new Gym(new GymId(1), new GymName("Gym1"), new GymEmail("gym1@test.com"),
                new GymPhone("+1 111"), new GymAddress("Addr1"),
                new GymPasswordHash("hash1"), new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now())));

        Gym gym2 = new Gym(new GymId(2), new GymName("Gym2"), new GymEmail("gym2@test.com"),
                new GymPhone("+1 222"), new GymAddress("Addr2"),
                new GymPasswordHash("hash2"), new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now())));

        assertNotNull(gym1);
        assertNotNull(gym2);
    }
}
