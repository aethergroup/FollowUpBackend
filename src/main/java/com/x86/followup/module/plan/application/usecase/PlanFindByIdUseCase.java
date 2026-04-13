package com.x86.followup.module.plan.application.usecase;

import com.x86.followup.module.plan.domain.model.Plan;
import com.x86.followup.module.plan.domain.model.PlanId;
import com.x86.followup.module.plan.domain.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlanFindByIdUseCase {

    private final PlanRepository repository;

    public Optional<Plan> execute(PlanId id){

        if (id == null){
            return Optional.empty();
        }
        return repository.findById(id);
    }

}
