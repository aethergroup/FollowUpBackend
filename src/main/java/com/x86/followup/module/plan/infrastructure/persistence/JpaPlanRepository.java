package com.x86.followup.module.plan.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPlanRepository extends JpaRepository<PlanEntity, Integer> {}
