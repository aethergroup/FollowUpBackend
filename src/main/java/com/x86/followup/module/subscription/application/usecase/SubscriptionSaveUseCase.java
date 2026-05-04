package com.x86.followup.module.subscription.application.usecase;

import com.x86.followup.module.subscription.domain.exception.SubscriptionAlreadyExistsException;
import com.x86.followup.module.subscription.domain.exception.SubscriptionNotValidError;
import com.x86.followup.module.subscription.domain.model.Subscription;
import com.x86.followup.module.subscription.domain.model.SubscriptionEnd;
import com.x86.followup.module.subscription.domain.model.SubscriptionPlanId;
import com.x86.followup.module.subscription.domain.model.SubscriptionStart;
import com.x86.followup.module.subscription.domain.model.SubscriptionStatus;
import com.x86.followup.module.subscription.domain.model.SubscriptionUserId;
import com.x86.followup.module.subscription.domain.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SubscriptionSaveUseCase {

    private final SubscriptionRepository repository;

    private static final int MAXSubscriptionDurationDays = 730;
    private static final int MIN_SUBSCRIPTION_DURATION_DAYS = 1;
    private static final String ACTIVE_STATUS = "ACTIVO";

    public void execute(Subscription subscription) {
        if (subscription == null) {
            throw new SubscriptionNotValidError("La suscripción no puede ser nula");
        }
        
        validateUserId(subscription.getUserId());
        validatePlanId(subscription.getPlanId());
        validateStartDate(subscription.getStart());
        validateEndDate(subscription.getEnd(), subscription.getStart());
        validateStatus(subscription.getStatus());
        validateSubscriptionDates(subscription.getStart(), subscription.getEnd());
        
        checkSubscriptionAlreadyExists(subscription);
        
        repository.save(subscription);
    }

    private void validateUserId(SubscriptionUserId userId) {
        if (userId == null) {
            throw new SubscriptionNotValidError("El usuario es obligatorio");
        }
        
        if (userId.getValue() == null) {
            throw new SubscriptionNotValidError("El ID de usuario no puede ser nulo");
        }
        
        if (userId.getValue() <= 0) {
            throw new SubscriptionNotValidError("El ID de usuario debe ser un número positivo");
        }
        
        if (userId.getValue() < 1) {
            throw new SubscriptionNotValidError("El ID de usuario debe ser mayor a 0");
        }
        
        if (userId.getValue() > Integer.MAX_VALUE) {
            throw new SubscriptionNotValidError("El ID de usuario excede el límite permitido");
        }
    }

    private void validatePlanId(SubscriptionPlanId planId) {
        if (planId == null) {
            throw new SubscriptionNotValidError("El plan es obligatorio");
        }
        
        if (planId.getValue() == null) {
            throw new SubscriptionNotValidError("El ID del plan no puede ser nulo");
        }
        
        if (planId.getValue() <= 0) {
            throw new SubscriptionNotValidError("El ID del plan debe ser un número positivo");
        }
        
        if (planId.getValue() < 1) {
            throw new SubscriptionNotValidError("El ID del plan debe ser mayor a 0");
        }
        
        if (planId.getValue() > Integer.MAX_VALUE) {
            throw new SubscriptionNotValidError("El ID del plan excede el límite permitido");
        }
    }

    private void validateStartDate(SubscriptionStart start) {
        if (start == null) {
            throw new SubscriptionNotValidError("La fecha de inicio es obligatoria");
        }
        
        if (start.getValue() == null) {
            throw new SubscriptionNotValidError("La fecha de inicio no puede ser nula");
        }
        
        Date now = new Date();
        if (start.getValue().before(now)) {
            throw new SubscriptionNotValidError("La fecha de inicio no puede ser en el pasado");
        }
        
        LocalDateTime startDateTime = start.getValue().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        
        if (startDateTime.getYear() < 2020) {
            throw new SubscriptionNotValidError("El año de inicio no puede ser anterior a 2020");
        }
        
        if (startDateTime.getYear() > 2100) {
            throw new SubscriptionNotValidError("El año de inicio no puede ser mayor a 2100");
        }
    }

    private void validateEndDate(SubscriptionEnd end, SubscriptionStart start) {
        if (end == null) {
            throw new SubscriptionNotValidError("La fecha de fin es obligatoria");
        }
        
        if (end.getValue() == null) {
            throw new SubscriptionNotValidError("La fecha de fin no puede ser nula");
        }
        
        if (start != null && start.getValue() != null) {
            if (end.getValue().before(start.getValue())) {
                throw new SubscriptionNotValidError("La fecha de fin debe ser posterior a la fecha de inicio");
            }
            
            if (end.getValue().equals(start.getValue())) {
                throw new SubscriptionNotValidError("La fecha de fin no puede ser igual a la fecha de inicio");
            }
            
            long diffInMillis = end.getValue().getTime() - start.getValue().getTime();
            long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);
            
            if (diffInDays < MIN_SUBSCRIPTION_DURATION_DAYS) {
                throw new SubscriptionNotValidError("La duración mínima de la suscripción debe ser de al menos 1 día");
            }
            
            if (diffInDays > MAXSubscriptionDurationDays) {
                throw new SubscriptionNotValidError("La duración máxima de la suscripción no puede exceder 2 años (730 días)");
            }
        }
    }

    private void validateStatus(SubscriptionStatus status) {
        if (status == null) {
            throw new SubscriptionNotValidError("El estado de la suscripción es obligatorio");
        }
        
        if (status.getValue() == null) {
            throw new SubscriptionNotValidError("El valor del estado no puede ser nulo");
        }
        
        if (status.getValue().trim().isEmpty()) {
            throw new SubscriptionNotValidError("El estado de la suscripción no puede estar vacío");
        }
        
        String statusValue = status.getValue().trim().toUpperCase();
        
        if (!statusValue.equals(ACTIVE_STATUS)) {
            throw new SubscriptionNotValidError("El estado inicial de la suscripción debe ser ACTIVO");
        }
    }

    private void validateSubscriptionDates(SubscriptionStart start, SubscriptionEnd end) {
        if (start == null || start.getValue() == null || end == null || end.getValue() == null) {
            return;
        }
        
        if (start.getValue().after(end.getValue())) {
            throw new SubscriptionNotValidError("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        
        if (Objects.equals(start.getValue(), end.getValue())) {
            throw new SubscriptionNotValidError("Las fechas de inicio y fin no pueden ser iguales");
        }
    }

    private void checkSubscriptionAlreadyExists(Subscription subscription) {
        if (subscription == null || subscription.getUserId() == null) {
            return;
        }
        
        repository.findByUserId(subscription.getUserId())
                .ifPresent(existing -> {
                    throw new SubscriptionAlreadyExistsException("El usuario con ID " 
                            + subscription.getUserId().getValue() 
                            + " ya tiene una suscripción activa");
                });
    }
}