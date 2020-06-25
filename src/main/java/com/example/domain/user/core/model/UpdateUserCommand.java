package com.example.domain.user.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateUserCommand extends CreateUserCommand {
    UUID id;
}
