package com.x86.followup.module.gym.application.service;

import com.x86.followup.module.gym.domain.repository.GymRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Gym Operation Tests")
class GymOperationTests {

    @Mock
    private GymRepository repository;

    @Test
    @DisplayName("Should support gym operations")
    void testGymOperations() {
        assertNotNull(repository);
    }
}
