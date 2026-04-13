package com.x86.followup.module.plan.application.usecase;

import com.x86.followup.module.plan.domain.exception.PlanExist;
import com.x86.followup.module.plan.domain.model.Plan;
import com.x86.followup.module.plan.domain.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanSaveUseCase {

    private final PlanRepository repository;

    public void execute(Plan plan){
        repository.findById(plan.getId())
                .ifPresent(existingUser -> {
                    throw new PlanExist("Este plan ya existe en nuestro sistema");
                });

        this.repository.save(plan);
    }

}
