package com.x86.followup.module.plan.application.service;

import com.x86.followup.module.plan.domain.model.Plan;
import com.x86.followup.module.plan.domain.model.PlanId;

import java.util.List;
import java.util.Optional;

public interface PlanService {
    void save (Plan plan);

    void update (Plan plan);

    void delete (PlanId id);

    List<Plan> findAll();

    Optional<Plan> findById (PlanId id);
}
