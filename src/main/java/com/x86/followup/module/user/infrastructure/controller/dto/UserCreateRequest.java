package com.x86.followup.module.user.infrastructure.controller.dto;

public record UserCreateRequest(
        String identificationType,
        String identification,
        Integer gymId,
        String name,
        String password,
        String phone,
        String paymentMethod
) {}
