package com.example.domain.user.core;

import com.example.domain.user.core.model.AddNewUserCommand;
import com.example.domain.user.core.model.CheckIsUserExistCommand;
import com.example.domain.user.core.model.DeleteUserCommand;
import com.example.domain.user.core.model.User;
import com.example.domain.user.core.ports.incoming.AddNewUser;
import com.example.domain.user.core.ports.incoming.CheckIsUserExist;
import com.example.domain.user.core.ports.incoming.DeleteUser;
import com.example.domain.user.core.ports.outgoing.UserDatabase;
import com.example.domain.user.infrastructure.mapper.UserMapper;

import javax.inject.Inject;
import java.util.Optional;

public class UserFacade implements AddNewUser, CheckIsUserExist, DeleteUser {
    @Inject
    UserDatabase userDatabase;

    @Inject
    UserMapper userMapper;

    @Override
    public Optional<User> handle(AddNewUserCommand addNewUserCommand) {
        User user = userMapper.fromAddNewUserCommand(addNewUserCommand);
        return userDatabase.save(user);
    }

    @Override
    public boolean handle(CheckIsUserExistCommand checkIsUserExistCommand) {
        return userDatabase.exist(checkIsUserExistCommand.getUserId());
    }

    @Override
    public void handle(DeleteUserCommand deleteUserCommand) {
        userDatabase.delete(deleteUserCommand.getUserId());
    }
}
