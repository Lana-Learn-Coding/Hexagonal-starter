package com.example.domain.user.core.ports.incoming;

import com.example.domain.user.core.model.FindOneUserCommand;
import com.example.domain.user.core.model.User;

import java.util.Optional;

public interface FindOneUser {
    Optional<User> handle(FindOneUserCommand findOneUserCommand);
}
