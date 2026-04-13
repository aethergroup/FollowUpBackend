package com.x86.followup.module.plan.application.usecase;

import com.x86.followup.module.plan.domain.model.Plan;
import com.x86.followup.module.plan.domain.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlanFindAllUseCase {

    private final PlanRepository repository;

    public List<Plan> execute(){
        return repository.findAll();
    }

}
