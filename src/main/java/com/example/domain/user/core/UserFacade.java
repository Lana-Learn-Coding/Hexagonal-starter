package com.example.domain.user.core;

import com.example.domain.user.core.model.*;
import com.example.domain.user.core.ports.incoming.*;
import com.example.domain.user.core.ports.outgoing.UserDatabase;
import com.example.domain.user.infrastructure.mapper.UserMapper;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserFacade implements CreateUser, CheckUserExist, DeleteUser, UpdateUser, FindOneUser, FindAllUser {
    private final UserDatabase userDatabase;
    private final UserMapper userMapper;

    @Override
    public Optional<User> handle(CreateUserCommand createUserCommand) {
        User user = userMapper.fromCreateUserCommand(createUserCommand);
        return userDatabase.save(user);
    }

    @Override
    public boolean handle(CheckUserExistCommand checkUserExistCommand) {
        return userDatabase.exist(checkUserExistCommand.getUserId());
    }

    @Override
    public void handle(DeleteUserCommand deleteUserCommand) {
        userDatabase.delete(deleteUserCommand.getUserId());
    }

    @Override
    public Optional<User> handle(UpdateUserCommand updateUserCommand) {
        User user = userMapper.fromUpdateUserCommand(updateUserCommand);
        return userDatabase.save(user);
    }

    @Override
    public List<User> handle(FindAllUserCommand findAllUserCommand) {
        return userDatabase.findAll();
    }

    @Override
    public Optional<User> handle(FindOneUserCommand findOneUserCommand) {
        return userDatabase.findOne(findOneUserCommand.getUserId());
    }
}
