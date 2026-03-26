package com.x86.followup.module.gym.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Getter
public class GymCreatedAt {
    private final Timestamp value;
}
