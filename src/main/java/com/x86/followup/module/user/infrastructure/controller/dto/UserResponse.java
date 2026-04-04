package com.x86.followup.module.user.infrastructure.controller.dto;

public record UserResponse(
        Integer id,
        Integer gymId,
        String role,
        String name,
        String phone,
        String status,
        String membershipEnd
) {}
