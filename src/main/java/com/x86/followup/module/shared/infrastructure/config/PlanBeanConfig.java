package com.x86.followup.module.shared.infrastructure.config;

import com.x86.followup.module.plan.application.usecase.*;
import com.x86.followup.module.plan.domain.repository.PlanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanBeanConfig {

    @Bean
    public PlanSaveUseCase planSaveUseCase(PlanRepository repository) {
        return new PlanSaveUseCase(repository);
    }

    @Bean
    public PlanUpdateUseCase planUpdateUseCase(PlanRepository repository) {
        return new PlanUpdateUseCase(repository);
    }

    @Bean
    public PlanDeleteUseCase planDeleteUseCase(PlanRepository repository) {
        return new PlanDeleteUseCase(repository);
    }

    @Bean
    public PlanFindAllUseCase planFindAllUseCase(PlanRepository repository) {
        return new PlanFindAllUseCase(repository);
    }

    @Bean
    public PlanFindByIdUseCase planFindByIdUseCase(PlanRepository repository) {
        return new PlanFindByIdUseCase(repository);
    }
}