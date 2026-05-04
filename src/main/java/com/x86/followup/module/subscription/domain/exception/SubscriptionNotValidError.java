package com.x86.followup.module.subscription.domain.exception;

public class SubscriptionNotValidError extends RuntimeException {
    public SubscriptionNotValidError(String message) {
        super(message);
    }
}