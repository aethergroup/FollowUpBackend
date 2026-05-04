package com.x86.followup.module.subscription.application.usecase;

import com.x86.followup.module.subscription.domain.exception.SubscriptionNotFoundError;
import com.x86.followup.module.subscription.domain.exception.SubscriptionNotValidError;
import com.x86.followup.module.subscription.domain.model.Subscription;
import com.x86.followup.module.subscription.domain.model.SubscriptionId;
import com.x86.followup.module.subscription.domain.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionUpdateUseCase {

    private final SubscriptionRepository repository;

    public void execute(Subscription subscription) {
        validateSubscriptionExists(subscription);
        
        validateSubscriptionData(subscription);
        
        repository.update(subscription);
    }

    private void validateSubscriptionExists(Subscription subscription) {
        if (subscription.getId() == null) {
            throw new SubscriptionNotValidError("El ID de la suscripción es obligatorio para actualizar");
        }
        
        boolean exists = repository.findById(subscription.getId()).isPresent();
        if (!exists) {
            throw new SubscriptionNotFoundError("Suscripción no encontrada con ID: " + subscription.getId().getValue());
        }
    }

    private void validateSubscriptionData(Subscription subscription) {
        if (subscription.getStart() != null && subscription.getEnd() != null) {
            if (subscription.getEnd().getValue().before(subscription.getStart().getValue())) {
                throw new SubscriptionNotValidError("La fecha de fin debe ser posterior a la fecha de inicio");
            }
        }
        
        if (subscription.getStatus() != null && subscription.getStatus().getValue() != null) {
            String status = subscription.getStatus().getValue().toUpperCase();
            if (!status.equals("ACTIVO") && !status.equals("PENDIENTE") && !status.equals("INACTIVO")) {
                throw new SubscriptionNotValidError("Estado de suscripción inválido. Debe ser: ACTIVO, PENDIENTE o INACTIVO");
            }
        }
    }
}