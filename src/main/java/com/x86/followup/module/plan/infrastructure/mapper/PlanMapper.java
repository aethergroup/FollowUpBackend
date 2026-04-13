package com.x86.followup.module.plan.infrastructure.mapper;

import com.x86.followup.module.plan.domain.model.*;
import com.x86.followup.module.plan.infrastructure.persistence.PlanEntity;
import org.springframework.stereotype.Component;

@Component
public class PlanMapper {
    public PlanEntity toEntity(Plan plan){
        if (plan == null){
            return null;
        }

        PlanEntity entity = new PlanEntity();

        if (plan.getId() != null){
            entity.setId(plan.getId().getValue());
        }

        entity.setGymId(plan.getGymId().getValue());
        entity.setName(plan.getName().getValue());
        entity.setPrice(plan.getPrice().getValue());
        entity.setDuration(plan.getDurationDay().getValue());
        entity.setDescription(plan.getDescription().getValue());
        entity.setIsActive(PlanIsActive.valueOf(plan.getIsActive().name()));

        return entity;
    }

    public Plan toDomain(PlanEntity entity){
        if (entity == null){
            return null;
        }

        return new Plan(
                new PlanId(entity.getId()),
                new PlanGymId(entity.getGymId()),
                new PlanName(entity.getName()),
                new PlanPrice(entity.getPrice()),
                new PlanDurationDay(entity.getDuration()),
                new PlanDescription(entity.getDescription()),
                PlanIsActive.valueOf(String.valueOf(entity.getIsActive()))
        );
    }
}
