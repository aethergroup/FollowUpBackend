package com.x86.followup.module.user.application.service;

import com.x86.followup.module.user.application.usecase.*;
import com.x86.followup.module.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void save(User user) {
        userSaveUseCase.execute(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userUpdateUseCase.execute(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        userDeleteUseCase.execute(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userFindAllUseCase.execute();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Integer id) {
        return userFindByIdUseCase.execute(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByIdentification(String identificationNumber) {
        return userFindByIdentificationUseCase.execute(identificationNumber);
    }
}