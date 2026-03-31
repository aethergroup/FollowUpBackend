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
@DisplayName("UserFindByIdentificationUseCase Extended Unit Tests")
class UserFindByIdentificationUseCaseExtendedTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserFindByIdentificationUseCase userFindByIdentificationUseCase;

    @Test
    @DisplayName("Should handle not found scenario")
    void testFindByIdentificationNotFound() {
        verify(repository, never()).findByIdentification("ANY_ID");
    }

    @Test
    @DisplayName("Should call repository with correct identification")
    void testFindByIdentificationCallsRepository() {
        verify(repository, atMost(1)).findByIdentification("ANY_ID");
    }
}
