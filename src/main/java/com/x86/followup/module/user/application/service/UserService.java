package com.x86.followup.module.user.application.service;

import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.model.UserIdentificationType;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(
            String name,
            String identificationNumber,
            UserIdentificationType identificationType,
            String phoneNumber,
            String paymentMethod,
            Timestamp membershipStart,
            Timestamp membershipEnd,
            String status,
            Timestamp createdAt
    );

    void update(
            Integer id,
            String name,
            String identificationNumber,
            UserIdentificationType identificationType,
            String phoneNumber,
            String paymentMethod,
            Timestamp membershipStart,
            Timestamp membershipEnd,
            String status
    );

    void delete(Integer id);

    List<User> findAll();

    Optional<User> findById(Integer id);

    Optional<User> findByIdentification(String identificationNumber);
}
