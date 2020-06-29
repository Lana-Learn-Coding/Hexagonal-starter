package com.example.domain.user.infrastructure.mapper;

import com.example.domain.user.core.model.CreateUserCommand;
import com.example.domain.user.core.model.UpdateUserCommand;
import com.example.domain.user.core.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    User fromCreateUserCommand(CreateUserCommand createUserCommand);
    User fromUpdateUserCommand(UpdateUserCommand updateUserCommand);
}
