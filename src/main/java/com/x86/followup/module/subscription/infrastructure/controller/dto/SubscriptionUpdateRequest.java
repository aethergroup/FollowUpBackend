package com.x86.followup.module.subscription.infrastructure.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public record SubscriptionUpdateRequest(
        Integer userId,
        Integer planId,
        Date startDate,
        Date endDate,
        String status
) {}
