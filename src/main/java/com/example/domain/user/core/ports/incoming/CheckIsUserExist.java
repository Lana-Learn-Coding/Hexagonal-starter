package com.example.domain.user.core.ports.incoming;

import com.example.domain.user.core.model.CheckIsUserExistCommand;

public interface CheckIsUserExist {
    boolean handle(CheckIsUserExistCommand command);
}
