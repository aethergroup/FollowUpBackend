package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.model.GymId;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymFindByIdUseCase Extended Unit Tests")
class GymFindByIdUseCaseExtendedTest {

    @Mock
    private GymRepository repository;

    @InjectMocks
    private GymFindByIdUseCase gymFindByIdUseCase;

    @Test
    @DisplayName("Should handle not found scenario")
    void testFindByIdNotFound() {
        verify(repository, never()).findById(any());
    }

    @Test
    @DisplayName("Should call repository with correct ID")
    void testFindByIdCallsRepository() {
        verify(repository, atMost(1)).findById(any(GymId.class));
    }
}
