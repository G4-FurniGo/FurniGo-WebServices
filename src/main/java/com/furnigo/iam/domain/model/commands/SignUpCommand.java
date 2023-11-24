package com.furnigo.iam.domain.model.commands;

public record SignUpCommand(
    String email,
    String password,
    String name,
    String lastName,
    String role,
    String phone,
    String pic
) {
}
