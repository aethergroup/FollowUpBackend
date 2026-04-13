package com.x86.followup.module.plan.domain.repository;

import com.x86.followup.module.plan.domain.model.Plan;
import com.x86.followup.module.plan.domain.model.PlanId;

import java.util.List;
import java.util.Optional;

public interface PlanRepository {
    Plan save(Plan plan);

    void update(Plan plan);

    void delete(PlanId planId);

    Optional<Plan> findById(PlanId planId);

    List<Plan> findAll();
}
