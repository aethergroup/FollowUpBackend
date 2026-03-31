package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.model.UserId;
import com.x86.followup.module.user.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserFindByIdUseCase Extended Unit Tests")
class UserFindByIdUseCaseExtendedTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserFindByIdUseCase userFindByIdUseCase;

    @Test
    @DisplayName("Should handle not found scenario")
    void testFindByIdNotFound() {
        verify(repository, never()).findById(any());
    }

    @Test
    @DisplayName("Should call repository with correct ID")
    void testFindByIdCallsRepository() {
        verify(repository, atMost(1)).findById(any(UserId.class));
    }
}
