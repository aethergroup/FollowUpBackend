package com.x86.followup.module.shared.infrastructure.config;

import com.x86.followup.module.subscription.application.usecase.*;
import com.x86.followup.module.subscription.domain.repository.SubscriptionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriptionBeanConfig {

    @Bean
    public SubscriptionSaveUseCase subscriptionSaveUseCase(SubscriptionRepository repository) {
        return new SubscriptionSaveUseCase(repository);
    }

    @Bean
    public SubscriptionUpdateUseCase subscriptionUpdateUseCase(SubscriptionRepository repository) {
        return new SubscriptionUpdateUseCase(repository);
    }

    @Bean
    public SubscriptionDeleteUseCase subscriptionDeleteUseCase(SubscriptionRepository repository) {
        return new SubscriptionDeleteUseCase(repository);
    }

    @Bean
    public SubscriptionFindAllUseCase subscriptionFindAllUseCase(SubscriptionRepository repository) {
        return new SubscriptionFindAllUseCase(repository);
    }

    @Bean
    public SubscriptionFindByIdUseCase subscriptionFindByIdUseCase(SubscriptionRepository repository) {
        return new SubscriptionFindByIdUseCase(repository);
    }

    @Bean
    public SubscriptionFindByUserIdUseCase subscriptionFindByUserIdUseCase(SubscriptionRepository repository) {
        return new SubscriptionFindByUserIdUseCase(repository);
    }
}
