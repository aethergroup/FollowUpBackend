package com.x86.followup.module.user.domain.repository;

import com.x86.followup.module.user.domain.model.User;
import com.x86.followup.module.user.domain.model.UserId;
import com.x86.followup.module.user.domain.model.UserIdentification;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    void update(User user);
    void delete(UserId id);

    Optional<User> findByIdentification(String identification);

    List<User> findAll();
    Optional<User> findById(UserId id);
    Optional<User> findByIdentification(UserIdentification identification);

    void deleteById(UserId id);
}
