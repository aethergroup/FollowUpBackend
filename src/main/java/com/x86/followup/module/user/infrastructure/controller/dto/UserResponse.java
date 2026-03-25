package com.x86.followup.module.user.infrastructure.controller.dto;

public record UserResponse(
        Integer id,
        String name,
        String phone,
        String status,
        String membershipEnd
) {}
