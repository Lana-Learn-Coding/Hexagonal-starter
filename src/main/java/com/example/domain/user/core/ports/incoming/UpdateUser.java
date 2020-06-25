package com.example.domain.user.core.ports.incoming;

import com.example.domain.user.core.model.UpdateUserCommand;
import com.example.domain.user.core.model.User;

import java.util.Optional;

public interface UpdateUser {
    Optional<User> handle(UpdateUserCommand updateUserCommand);
}
