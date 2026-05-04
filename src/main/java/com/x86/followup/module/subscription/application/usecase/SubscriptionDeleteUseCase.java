package com.x86.followup.module.subscription.application.usecase;

import com.x86.followup.module.subscription.domain.exception.SubscriptionNotFoundError;
import com.x86.followup.module.subscription.domain.model.SubscriptionId;
import com.x86.followup.module.subscription.domain.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class SubscriptionDeleteUseCase {

    private static final Logger logger = Logger.getLogger(SubscriptionDeleteUseCase.class.getName());
    private final SubscriptionRepository repository;

    public void execute(Integer id) {
        if (id == null) {
            throw new SubscriptionNotFoundError("El ID de suscripción no puede ser nulo");
        }

        SubscriptionId subscriptionId = new SubscriptionId(id);
        
        boolean exists = repository.findById(subscriptionId).isPresent();
        if (!exists) {
            logger.log(Level.WARNING, "Intento de eliminar suscripción inexistente con ID: {0}", id);
            throw new SubscriptionNotFoundError("Suscripción no encontrada con ID: " + id);
        }

        repository.delete(subscriptionId);
        logger.log(Level.INFO, "Suscripción eliminada exitosamente con ID: {0}", id);
    }
}