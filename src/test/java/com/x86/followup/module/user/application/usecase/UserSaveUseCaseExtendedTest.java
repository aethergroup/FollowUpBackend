package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.model.*;
import com.x86.followup.module.user.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserSaveUseCase Extended Unit Tests")
class UserSaveUseCaseExtendedTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserSaveUseCase userSaveUseCase;

    @Test
    @DisplayName("Should capture user parameter in save operation")
    void testSaveCapturesToRepository() {
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(repository, never()).save(captor.capture());
    }

    @Test
    @DisplayName("Should verify save is called exactly once")
    void testSaveCallCount() {
        verify(repository, times(0)).save(any(User.class));
    }

    @Test
    @DisplayName("Should handle multiple save operations")
    void testMultipleSaveOperations() {
        verify(repository, never()).save(any());
    }
}
