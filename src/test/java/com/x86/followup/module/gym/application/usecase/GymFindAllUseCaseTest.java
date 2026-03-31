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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymFindAllUseCase Tests")
class GymFindAllUseCaseTest {

    @Mock
    private GymRepository repository;

    @InjectMocks
    private GymFindAllUseCase gymFindAllUseCase;

    private Gym createTestGym(Integer id, String name) {
        return new Gym(
                new GymId(id),
                new GymName(name),
                new GymEmail(name + "@gym.com"),
                new GymPhone("+1 " + id),
                new GymAddress("Street " + id),
                new GymPasswordHash("password" + id),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should find all gyms successfully")
    void testFindAllSuccess() {
        List<Gym> gyms = List.of(
                createTestGym(1, "Gym 1"),
                createTestGym(2, "Gym 2"),
                createTestGym(3, "Gym 3")
        );
        when(repository.findAll()).thenReturn(gyms);

        List<Gym> result = gymFindAllUseCase.execute();

        assertNotNull(result);
        assertEquals(3, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should return empty list when no gyms exist")
    void testFindAllEmpty() {
        when(repository.findAll()).thenReturn(List.of());

        List<Gym> result = gymFindAllUseCase.execute();

        assertTrue(result.isEmpty());
    }
}
