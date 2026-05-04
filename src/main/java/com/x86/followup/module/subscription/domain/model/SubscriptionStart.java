package com.x86.followup.module.subscription.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class SubscriptionStart {
    private final Date value;
}