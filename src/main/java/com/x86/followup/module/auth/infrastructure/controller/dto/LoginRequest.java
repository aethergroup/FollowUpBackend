package com.x86.followup.module.auth.infrastructure.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank String identification,
        @NotBlank String password
) {}