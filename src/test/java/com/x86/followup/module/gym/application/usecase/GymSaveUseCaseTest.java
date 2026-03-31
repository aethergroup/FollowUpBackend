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
@DisplayName("GymSaveUseCase Tests")
class GymSaveUseCaseTest {

    @Mock
    private GymRepository repository;

    @InjectMocks
    private GymSaveUseCase gymSaveUseCase;

    private Gym createTestGym() {
        return new Gym(
                null,
                new GymName("New Gym"),
                new GymEmail("newgym@example.com"),
                new GymPhone("+1 9876543210"),
                new GymAddress("456 Oak St"),
                new GymPasswordHash("new_password"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should save gym successfully")
    void testSaveGymSuccess() {
        Gym gym = createTestGym();
        gymSaveUseCase.execute(gym);
        verify(repository, times(1)).save(gym);
    }

    @Test
    @DisplayName("Should call repository save method")
    void testSaveUsesRepository() {
        Gym gym = createTestGym();
        gymSaveUseCase.execute(gym);
        verify(repository).save(any(Gym.class));
    }
}
