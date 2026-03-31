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
@DisplayName("GymSaveUseCase Unit Tests")
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
    @DisplayName("Should execute save usecase")
    void testSaveGymSuccess() {
        Gym gym = createTestGym();
        gymSaveUseCase.execute(gym);
        verify(repository, times(1)).save(gym);
    }

    @Test
    @DisplayName("Should delegate to repository")
    void testSaveUsesRepository() {
        Gym gym = createTestGym();
        gymSaveUseCase.execute(gym);
        verify(repository).save(any(Gym.class));
    }

    @Test
    @DisplayName("Should handle gym with all fields")
    void testSaveGymWithAllFields() {
        Gym gym = new Gym(
                new GymId(1),
                new GymName("Complete Gym"),
                new GymEmail("complete@gym.com"),
                new GymPhone("+1 5555555555"),
                new GymAddress("789 Complete Ave"),
                new GymPasswordHash("hashed_pwd"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
        
        gymSaveUseCase.execute(gym);
        verify(repository).save(gym);
    }
}
