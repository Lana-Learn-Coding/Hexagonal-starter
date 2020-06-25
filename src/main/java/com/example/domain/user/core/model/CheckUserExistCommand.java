package com.example.domain.user.core.model;

import lombok.Data;

import java.util.UUID;

@Data
public class CheckUserExistCommand {
    private UUID userId;

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
