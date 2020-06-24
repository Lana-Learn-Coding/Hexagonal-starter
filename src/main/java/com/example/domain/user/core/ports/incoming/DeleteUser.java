package com.example.domain.user.core.ports.incoming;

import com.example.domain.user.core.model.DeleteUserCommand;

public interface DeleteUser {
    void handle(DeleteUserCommand command);
}
