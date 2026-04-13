package com.x86.followup.module.plan.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Plan {
    private PlanId id;
    private final PlanGymId gymId;
    private final PlanName name;
    private final PlanPrice price;
    private final PlanDurationDay durationDay;
    private final PlanDescription description;
    private final PlanIsActive isActive;

    public Plan(PlanId id,
                PlanGymId gymId,
                PlanName name,
                PlanPrice price,
                PlanDurationDay durationDay,
                PlanDescription description,
                PlanIsActive isActive) {
        this.id = id;
        this.gymId = gymId;
        this.name = Objects.requireNonNull(name, "El nombre es obligatorio");
        this.price = Objects.requireNonNull(price, "El precio es obligatorio");
        this.durationDay = Objects.requireNonNull(durationDay, "La duración es obligatoria");
        this.description = Objects.requireNonNull(description,"La descripción es obligatoria");
        this.isActive = Objects.requireNonNull(isActive, "El status es obligatorio");
    }
}
