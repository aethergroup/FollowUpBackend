package com.x86.followup.module.user.application.service;

import com.x86.followup.module.user.application.usecase.*;
import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.model.UserIdentificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserSaveUseCase userSaveUseCase;
    private final UserUpdateUseCase userUpdateUseCase;
    private final UserDeleteUseCase userDeleteUseCase;
    private final UserFindAllUseCase userFindAllUseCase;
    private final UserFindByIdUseCase userFindByIdUseCase;
    private final UserFindByIdentificationUseCase userFindByIdentificationUseCase;

    @Override
    public void save(String name,
                     String identificationNumber,
                     UserIdentificationType identificationType,
                     String phoneNumber,
                     String paymentMethod,
                     Timestamp membershipStart,
                     Timestamp membershipEnd,
                     String status,
                     Timestamp createdAt) {

        userSaveUseCase.execute(
                name,
                identificationNumber,
                identificationType,
                phoneNumber,
                paymentMethod,
                membershipStart,
                membershipEnd,
                status,
                createdAt
        );
    }

    @Override
    public void update(Integer id,
                       String name,
                       String identificationNumber,
                       UserIdentificationType identificationType,
                       String phoneNumber,
                       String paymentMethod,
                       Timestamp membershipStart,
                       Timestamp membershipEnd,
                       String status) {

        userUpdateUseCase.execute(
                id,
                name,
                identificationNumber,
                identificationType,
                phoneNumber,
                paymentMethod,
                membershipStart,
                membershipEnd,
                status
        );
    }

    @Override
    public void delete(Integer id) {
        userDeleteUseCase.execute(id);
    }

    @Override
    public List<User> findAll() {
        return userFindAllUseCase.execute();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userFindByIdUseCase.execute(id);
    }

    @Override
    public Optional<User> findByIdentification(String identificationNumber) {
        return userFindByIdentificationUseCase.execute(identificationNumber);
    }
}