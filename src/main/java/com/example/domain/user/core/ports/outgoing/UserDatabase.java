package com.example.domain.user.core.ports.outgoing;

import com.example.domain.user.core.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDatabase {
    Optional<User> findOne(UUID id);

    Optional<User> save(User user);

    void delete(UUID id);

    boolean exist(UUID id);

    List<User> findAll();
}
