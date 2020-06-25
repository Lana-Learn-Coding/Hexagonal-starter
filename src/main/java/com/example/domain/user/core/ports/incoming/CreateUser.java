package com.example.domain.user.core.ports.incoming;

import com.example.domain.user.core.model.CreateUserCommand;
import com.example.domain.user.core.model.User;

import java.util.Optional;

public interface CreateUser {
    Optional<User> handle(CreateUserCommand createUserCommand);
}
