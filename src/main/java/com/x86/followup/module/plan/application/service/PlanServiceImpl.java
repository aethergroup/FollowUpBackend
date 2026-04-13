package com.x86.followup.module.plan.application.service;

import com.x86.followup.module.plan.application.usecase.*;
import com.x86.followup.module.plan.domain.model.Plan;
import com.x86.followup.module.plan.domain.model.PlanId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final PlanSaveUseCase planSaveUseCase;
    private final PlanUpdateUseCase planUpdateUseCase;
    private final PlanDeleteUseCase planDeleteUseCase;
    private final PlanFindAllUseCase planFindAllUseCase;
    private final PlanFindByIdUseCase planFindByIdUseCase;

    @Override
    @Transactional
    public void save(Plan plan){
        planSaveUseCase.execute(plan);
    }

    @Override
    @Transactional
    public void update(Plan plan){
        planUpdateUseCase.execute(plan);
    }

    @Override
    @Transactional
    public void delete (PlanId id){
        planDeleteUseCase.execute(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Plan> findAll(){
        return planFindAllUseCase.execute();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Plan> findById(PlanId id){
        return planFindByIdUseCase.execute(id);
    }
}
