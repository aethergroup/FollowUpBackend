package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.model.GymId;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymDeleteUseCase Tests")
class GymDeleteUseCaseTest {

    @Mock
    private GymRepository repository;

    @InjectMocks
    private GymDeleteUseCase gymDeleteUseCase;

    @Test
    @DisplayName("Should delete gym successfully")
    void testDeleteGymSuccess() {
        Integer gymId = 1;
        gymDeleteUseCase.execute(gymId);
        verify(repository, times(1)).delete(new GymId(gymId));
    }

    @Test
    @DisplayName("Should call repository delete method")
    void testDeleteUsesRepository() {
        Integer gymId = 5;
        gymDeleteUseCase.execute(gymId);
        verify(repository).delete(any(GymId.class));
    }
}
