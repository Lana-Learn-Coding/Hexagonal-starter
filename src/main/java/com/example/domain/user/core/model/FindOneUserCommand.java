package com.example.domain.user.core.model;

import lombok.Data;

import java.util.UUID;

@Data
public class FindOneUserCommand {
    private UUID userId;

    public FindOneUserCommand(UUID userId) {
        this.userId = userId;
    }
}
