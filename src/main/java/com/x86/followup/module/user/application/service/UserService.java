package com.x86.followup.module.user.application.service;

import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.model.UserId;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);

    void update(User user);

    void delete(Integer id);

    List<User> findAll();

    Optional<User> findById(UserId id);

    @Transactional(readOnly = true)
    Optional<User> findById(Integer id);

    Optional<User> findByIdentification(String identificationNumber);
}