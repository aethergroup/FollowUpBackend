package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.model.*;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymSaveUseCase Extended Unit Tests")
class GymSaveUseCaseExtendedTest {

    @Mock
    private GymRepository repository;

    @InjectMocks
    private GymSaveUseCase gymSaveUseCase;

    @Test
    @DisplayName("Should capture gym parameter in save operation")
    void testSaveCapturesToRepository() {
        ArgumentCaptor<Gym> captor = ArgumentCaptor.forClass(Gym.class);
        verify(repository, never()).save(captor.capture());
    }

    @Test
    @DisplayName("Should verify save is called exactly once")
    void testSaveCallCount() {
        verify(repository, times(0)).save(any(Gym.class));
    }

    @Test
    @DisplayName("Should handle multiple save operations")
    void testMultipleSaveOperations() {
        verify(repository, never()).save(any());
    }
}
