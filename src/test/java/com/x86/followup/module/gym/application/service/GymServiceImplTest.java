package com.x86.followup.module.gym.application.service;

import com.x86.followup.module.gym.application.usecase.*;
import com.x86.followup.module.gym.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GymServiceImpl Tests")
class GymServiceImplTest {

    @Mock
    private GymSaveUseCase saveUseCase;

    @Mock
    private GymUpdateUseCase updateUseCase;

    @Mock
    private GymDeleteUseCase deleteUseCase;

    @Mock
    private GymFindByIdUseCase findByIdUseCase;

    @Mock
    private GymFindAllUseCase findAllUseCase;

    @InjectMocks
    private GymServiceImpl gymService;

    private Gym createTestGym() {
        return new Gym(
                new GymId(1),
                new GymName("Test Gym"),
                new GymEmail("test@gym.com"),
                new GymPhone("+1 234567890"),
                new GymAddress("123 Main St"),
                new GymPasswordHash("hashed_password"),
                new GymCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        );
    }

    @Test
    @DisplayName("Should save gym through service")
    void testSaveGym() {
        Gym gym = createTestGym();
        gymService.save(gym);
        verify(saveUseCase, times(1)).execute(gym);
    }

    @Test
    @DisplayName("Should update gym through service")
    void testUpdateGym() {
        Gym gym = createTestGym();
        gymService.update(gym);
        verify(updateUseCase, times(1)).execute(gym);
    }

    @Test
    @DisplayName("Should delete gym through service")
    void testDeleteGym() {
        Integer gymId = 1;
        gymService.delete(gymId);
        verify(deleteUseCase, times(1)).execute(gymId);
    }

    @Test
    @DisplayName("Should find gym by id through service")
    void testFindById() {
        Integer gymId = 1;
        Gym gym = createTestGym();
        when(findByIdUseCase.execute(gymId)).thenReturn(Optional.of(gym));

        Optional<Gym> result = gymService.findById(gymId);

        assertTrue(result.isPresent());
        verify(findByIdUseCase, times(1)).execute(gymId);
    }

    @Test
    @DisplayName("Should find all gyms through service")
    void testFindAll() {
        List<Gym> gyms = List.of(createTestGym());
        when(findAllUseCase.execute()).thenReturn(gyms);

        List<Gym> result = gymService.findAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(findAllUseCase, times(1)).execute();
    }
}
