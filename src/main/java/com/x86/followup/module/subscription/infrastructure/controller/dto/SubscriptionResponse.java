package com.x86.followup.module.subscription.infrastructure.controller.dto;

import java.util.Date;

public record SubscriptionResponse(
        Integer id,
        Integer userId,
        Integer planId,
        Date start,
        Date end,
        String status
) {}
