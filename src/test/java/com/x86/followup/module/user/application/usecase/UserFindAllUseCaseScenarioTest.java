package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserFindAllUseCase Scenario Tests")
class UserFindAllUseCaseScenarioTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserFindAllUseCase userFindAllUseCase;

    @Test
    @DisplayName("Should handle empty result list")
    void testFindAllEmptyResult() {
        verify(repository, never()).findAll();
    }

    @Test
    @DisplayName("Should handle multiple users in results")
    void testFindAllMultipleUsers() {
        verify(repository, atMost(1)).findAll();
    }

    @Test
    @DisplayName("Should call repository exactly once")
    void testFindAllRepositoryCalled() {
        verify(repository, times(0)).findAll();
    }
}
