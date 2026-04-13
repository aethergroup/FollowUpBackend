package com.x86.followup.module.plan.infrastructure.controller.dto;

public record PlanCreateRequest(
        Integer gymId,
        String name,
        Double price,
        String duration,
        String description
) {}
