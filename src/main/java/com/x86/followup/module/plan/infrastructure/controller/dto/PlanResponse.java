package com.x86.followup.module.plan.infrastructure.controller.dto;

public record PlanResponse(
        String name,
        Double price,
        String duration,
        String description
) {}
