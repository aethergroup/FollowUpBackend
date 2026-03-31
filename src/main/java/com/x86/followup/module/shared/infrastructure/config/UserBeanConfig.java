package com.x86.followup.module.shared.infrastructure.config;

import com.x86.followup.module.auth.domain.repository.AuthRepository;
import com.x86.followup.module.user.application.usecase.*;
import com.x86.followup.module.user.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfig {

    @Bean
    public UserSaveUseCase userSaveUseCase(
            UserRepository repository,
            AuthRepository authRepository) {
        return new UserSaveUseCase(repository, authRepository);
    }

    @Bean
    public UserUpdateUseCase userUpdateUseCase(
            UserRepository repository,
            AuthRepository authRepository
    ) {
        return new UserUpdateUseCase(repository, authRepository);
    }

    @Bean
    public UserFindAllUseCase userFindAllUseCase(UserRepository repository) {
        return new UserFindAllUseCase(repository);
    }

    @Bean
    public UserFindByIdUseCase userFindByIdUseCase(UserRepository repository) {
        return new UserFindByIdUseCase(repository);
    }

    @Bean
    public UserDeleteUseCase userDeleteUseCase(UserRepository repository) {
        return new UserDeleteUseCase(repository);
    }

    @Bean
    public UserFindByIdentificationUseCase userFindByIdentificationUseCase (UserRepository repository){
        return new UserFindByIdentificationUseCase(repository);
    }
}
