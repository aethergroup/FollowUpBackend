package com.x86.followup.module.subscription.domain.exception;

public class SubscriptionNotFoundError extends RuntimeException {
    public SubscriptionNotFoundError(String message) {
        super(message);
    }
}