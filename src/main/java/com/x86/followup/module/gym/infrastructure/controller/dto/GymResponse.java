package com.x86.followup.module.gym.infrastructure.controller.dto;

public record GymResponse(
        Integer id,
        String name,
        String email,
        String phone,
        String address
) {
}
