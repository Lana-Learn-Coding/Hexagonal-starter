package com.example.domain.user.core.ports.incoming;

import com.example.domain.user.core.model.AddNewUserCommand;
import com.example.domain.user.core.model.User;

import java.util.Optional;

public interface AddNewUser {
    Optional<User> handle(AddNewUserCommand user);
}
