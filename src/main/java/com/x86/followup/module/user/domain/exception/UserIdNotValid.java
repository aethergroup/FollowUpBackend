package com.x86.followup.module.user.domain.exception;

public class UserIdNotValid extends RuntimeException {
    public UserIdNotValid(String message) {
        super(message);
    }
}
