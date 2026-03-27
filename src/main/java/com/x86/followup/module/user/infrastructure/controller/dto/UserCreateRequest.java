package com.x86.followup.module.user.infrastructure.controller.dto;

public record UserCreateRequest(
        String name,
        String identification,
        String identificationType,
        String phone,
        String paymentMethod,
        Integer gymId
) {}
