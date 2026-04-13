package com.x86.followup.module.plan.domain.exception;

public class PlanExist extends RuntimeException {
    public PlanExist(String message) {
        super(message);
    }
}
