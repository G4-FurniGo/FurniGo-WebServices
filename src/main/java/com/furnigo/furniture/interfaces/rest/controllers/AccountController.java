package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.domain.services.UserCommandService;
import com.furnigo.furniture.domain.services.UserQueryService;
import com.furnigo.furniture.interfaces.rest.resources.CreateNewUserResource;
import com.furnigo.furniture.interfaces.rest.resources.LoginResource;
import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public AccountController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @GetMapping("/login")
    @Transactional
    public void login(@RequestBody LoginResource resource){
        // Return JWT token
        boolean isValid = userCommandService.login(resource);
    }

    @PostMapping("/register")
    @Transactional
    public void register(@RequestBody CreateNewUserResource resource){
        // Return JWT token
        boolean isValid = userCommandService.register(resource);

    }

}
