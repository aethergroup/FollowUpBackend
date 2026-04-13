package com.x86.followup.module.plan.application.usecase;

import com.x86.followup.module.plan.domain.exception.PlanNotFound;
import com.x86.followup.module.plan.domain.model.PlanId;
import com.x86.followup.module.plan.domain.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanDeleteUseCase {

    private final PlanRepository repository;

    public void execute(PlanId id){

        if (!repository.findById(id).isPresent()){
            throw new PlanNotFound("Este plan no existe en nuestro sistema");
        }

        this.repository.delete(id);
    }

}
