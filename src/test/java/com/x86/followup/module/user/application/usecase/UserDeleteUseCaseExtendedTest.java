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
@DisplayName("UserDeleteUseCase Unit Tests")
class UserDeleteUseCaseExtendedTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserDeleteUseCase userDeleteUseCase;

    @Test
    @DisplayName("Should delete user successfully")
    void testDeleteUserSuccess() {
        Integer userId = 1;
        userDeleteUseCase.execute(userId);
        verify(repository, times(1)).delete(new UserId(userId));
    }

    @Test
    @DisplayName("Should call repository delete method")
    void testDeleteUsesRepository() {
        Integer userId = 5;
        userDeleteUseCase.execute(userId);
        verify(repository).delete(any(UserId.class));
    }

    @Test
    @DisplayName("Should handle deletion of different user IDs")
    void testDeleteMultipleUsers() {
        userDeleteUseCase.execute(1);
        userDeleteUseCase.execute(2);
        userDeleteUseCase.execute(3);
        
        verify(repository, times(3)).delete(any(UserId.class));
    }
}
