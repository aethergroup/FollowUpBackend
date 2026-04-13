package com.x86.followup.module.plan.application.usecase;

import com.x86.followup.module.plan.domain.exception.PlanNotFound;
import com.x86.followup.module.plan.domain.model.Plan;
import com.x86.followup.module.plan.domain.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanUpdateUseCase {

    private final PlanRepository repository;

    public void execute(Plan plan){
        if (plan.getId() == null || repository.findById(plan.getId()).isEmpty()){
            throw new PlanNotFound("Este plan no existe");
        }

        this.repository.update(plan);
    }

}
