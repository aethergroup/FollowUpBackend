package com.x86.followup.module.shared.infrastructure.config;

import com.x86.followup.module.gym.application.usecase.*;
import com.x86.followup.module.gym.domain.repository.GymRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GymBeanConfig {

    @Bean
    public GymSaveUseCase gymSaveUseCase(GymRepository repository){ return new GymSaveUseCase(repository); }

    @Bean
    public GymUpdateUseCase gymUpdateUseCase(GymRepository repository){ return new GymUpdateUseCase(repository); }

    @Bean
    public GymDeleteUseCase gymDeleteUseCase(GymRepository repository){ return new GymDeleteUseCase(repository); }

    @Bean
    public GymFindByIdUseCase gymFindByIdUseCase(GymRepository repository){ return new GymFindByIdUseCase(repository); }

    @Bean
    public GymFindAllUseCase gymFindAllUseCase(GymRepository repository){ return new GymFindAllUseCase(repository); }
}
