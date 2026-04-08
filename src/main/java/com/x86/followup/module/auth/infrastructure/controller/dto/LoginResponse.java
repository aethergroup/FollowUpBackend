package com.x86.followup.module.auth.infrastructure.controller.dto;

public record LoginResponse(
        String access_token,
        String token_type,
        String rol
) {}
