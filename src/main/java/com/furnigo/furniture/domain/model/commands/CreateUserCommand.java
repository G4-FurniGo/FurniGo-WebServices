package com.furnigo.furniture.domain.model.commands;

import com.furnigo.furniture.domain.model.valueobjects.Name;

public record CreateUserCommand(Name name, String email, String password, String phoneNumber, String address) {

}
