package com.x86.followup.module.gym.application.usecase;

import com.x86.followup.module.gym.domain.model.*;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymUpdateUseCase Tests")
class GymUpdateUseCaseTest {

    @Mock
    private GymRepository repository;

    @InjectMocks
    private GymUpdateUseCase gymUpdateUseCase;

    private Gym createTestGym() {
        return new Gym(
                new GymId(1),
                new GymName("Updated Gym"),
                new GymEmail("updated@gym.com"),
                new GymPhone("+1 1234567890"),
                new GymAddress("999 Update St"),
                new GymPasswordHash("new_hash"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should update gym successfully")
    void testUpdateGymSuccess() {
        Gym gym = createTestGym();
        gymUpdateUseCase.execute(gym);
        verify(repository, times(1)).update(gym);
    }

    @Test
    @DisplayName("Should call repository update method")
    void testUpdateUsesRepository() {
        Gym gym = createTestGym();
        gymUpdateUseCase.execute(gym);
        verify(repository).update(any(Gym.class));
    }
}
