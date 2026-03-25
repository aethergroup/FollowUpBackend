package com.x86.followup.module.user.infrastructure.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UserUpdateRequest(
        String name,
        String phone,
        String identification,
        String identificationType,
        String paymentMethod,
        String status,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime membershipEnd
) {}
