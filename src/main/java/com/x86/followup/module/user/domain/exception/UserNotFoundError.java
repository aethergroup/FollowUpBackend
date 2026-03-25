package com.x86.followup.module.user.domain.exception;

public class UserNotFoundError extends RuntimeException {
    public UserNotFoundError(String message) {
        super(message);
    }
}
