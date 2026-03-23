package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.model.*;
import com.x86.followup.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserSaveUseCase {
    private final UserRepository repository;

    public void execute(
            String name,
            String identificationNumber,
            UserIdentificationType identificationType,
            String phoneNumber,
            String paymentMethod,
            java.sql.Timestamp membershipStart,
            java.sql.Timestamp membershipEnd,
            String status,
            java.sql.Timestamp createdAt
    ) {
        User user = new User(
                new UserName(name),
                new UserIdentification(identificationNumber),
                identificationType,
                new UserPhone(phoneNumber),
                new UserMembershipStart(membershipStart),
                new UserMembershipEnd(membershipEnd),
                UserPaymentMethod.valueOf(paymentMethod.toUpperCase()),
                UserStatus.valueOf(status.toUpperCase()),
                new UserCreatedAt(createdAt)
        );
        this.repository.save(user);
    }
}