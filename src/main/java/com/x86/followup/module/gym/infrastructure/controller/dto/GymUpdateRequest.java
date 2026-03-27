package com.x86.followup.module.gym.infrastructure.controller.dto;

public record GymUpdateRequest(
        String name,
        String email,
        String phone,
        String address,
        String password
) {
}
