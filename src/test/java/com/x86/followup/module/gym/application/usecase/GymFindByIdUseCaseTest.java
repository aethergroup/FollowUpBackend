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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymFindByIdUseCase Tests")
class GymFindByIdUseCaseTest {

    @Mock
    private GymRepository repository;

    @InjectMocks
    private GymFindByIdUseCase gymFindByIdUseCase;

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
    @DisplayName("Should find gym by id successfully")
    void testFindByIdSuccess() {
        Integer gymId = 1;
        Gym gym = createTestGym(gymId);
        when(repository.findById(any(GymId.class))).thenReturn(Optional.of(gym));

        Optional<Gym> result = gymFindByIdUseCase.execute(gymId);

        assertTrue(result.isPresent());
        assertEquals(gym, result.get());
        verify(repository, times(1)).findById(any(GymId.class));
    }

    @Test
    @DisplayName("Should return empty Optional when gym not found")
    void testFindByIdNotFound() {
        Integer gymId = 999;
        when(repository.findById(any(GymId.class))).thenReturn(Optional.empty());

        Optional<Gym> result = gymFindByIdUseCase.execute(gymId);

        assertTrue(result.isEmpty());
    }
}
