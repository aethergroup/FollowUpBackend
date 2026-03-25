package com.x86.followup.module.user.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Getter
public class UserMembershipEnd {
    private final Timestamp value;
}
