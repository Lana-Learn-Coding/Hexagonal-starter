package com.example.domain.user.core.ports.incoming;

import com.example.domain.user.core.model.CheckUserExistCommand;

public interface CheckUserExist {
    boolean handle(CheckUserExistCommand command);
}
