package com.x86.followup.module.user.application.usecase;

import com.x86.followup.module.user.domain.model.*;
import com.x86.followup.module.user.domain.repository.UserRepository;
import com.x86.followup.module.user.domain.exception.UserNotFoundError; // Ajustado el nombre del paquete de excepciones
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUpdateUseCase {
    private final UserRepository repository;

    public void execute(
            Integer id,
            String name,
            String identificationNumber,
            UserIdentificationType identificationType,
            String phoneNumber,
            String paymentMethod,
            java.sql.Timestamp membershipStart,
            java.sql.Timestamp membershipEnd,
            String status
    ) {
        User existingUser = repository.findById(new UserId(id))
                .orElseThrow(() -> new UserNotFoundError("User with ID " + id + " not found"));

        User updatedUser = new User(
                new UserName(name),
                new UserIdentification(identificationNumber),
                identificationType,
                new UserPhone(phoneNumber),
                new UserMembershipStart(membershipStart),
                new UserMembershipEnd(membershipEnd),
                UserPaymentMethod.valueOf(paymentMethod.toUpperCase()),
                UserStatus.valueOf(status.toUpperCase()),
                existingUser.getCreatedAt()
        );

        updatedUser.assignId(existingUser.getId());

        this.repository.update(updatedUser);
    }
}