package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.domain.services.UserCommandService;
import com.furnigo.furniture.domain.services.UserQueryService;
import com.furnigo.furniture.interfaces.rest.resources.CreateNewUserResource;
import com.furnigo.furniture.interfaces.rest.resources.LoggedInUserResource;
import com.furnigo.furniture.interfaces.rest.resources.LoginResource;
import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {/*
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;*/
/*
    public AccountController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }*/

    @GetMapping("/login")
    @Transactional
    public LoggedInUserResource login(@RequestBody LoginResource resource){
        // Get the user by the email
        // Compare the password
        // If the password is correct, generate JWT token and bundle it with the user resource
        // Else, return error message
        // Return LoggedInUserResource
        throw new UnsupportedOperationException();
    }

    @PostMapping("/sign-up")
    @Transactional
    public LoggedInUserResource register(@RequestBody CreateNewUserResource resource){
        // Check if the email is already registered
        // If not, create the user
        // Generate JWT token and bundle it with the user resource
        // Return LoggedInUserResource
        throw new UnsupportedOperationException();
    }
}
