package com.example.domain.user.core.ports.incoming;

import com.example.domain.user.core.model.FindAllUserCommand;
import com.example.domain.user.core.model.User;

import java.util.List;

public interface FindAllUser {
    List<User> handle(FindAllUserCommand findAllUserCommand);
}
