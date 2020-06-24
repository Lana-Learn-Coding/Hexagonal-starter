package com.example.domain.user.infrastructure.mapper;

import com.example.domain.user.core.model.AddNewUserCommand;
import com.example.domain.user.core.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    User fromAddNewUserCommand(AddNewUserCommand addNewUserCommand);
}
