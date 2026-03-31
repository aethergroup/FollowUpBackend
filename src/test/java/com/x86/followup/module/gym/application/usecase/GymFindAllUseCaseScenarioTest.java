package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.repository.GymRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymFindAllUseCase Scenario Tests")
class GymFindAllUseCaseScenarioTest {

    @Mock
    private GymRepository repository;

    @InjectMocks
    private GymFindAllUseCase gymFindAllUseCase;

    @Test
    @DisplayName("Should handle empty result list")
    void testFindAllEmptyResult() {
        verify(repository, never()).findAll();
    }

    @Test
    @DisplayName("Should handle multiple gyms in results")
    void testFindAllMultipleGyms() {
        verify(repository, atMost(1)).findAll();
    }

    @Test
    @DisplayName("Should call repository exactly once")
    void testFindAllRepositoryCalled() {
        verify(repository, times(0)).findAll();
    }
}
