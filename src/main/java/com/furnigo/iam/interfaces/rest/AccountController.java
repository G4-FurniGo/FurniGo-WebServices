package com.furnigo.iam.interfaces.rest;

import com.furnigo.iam.domain.services.UserCommandService;
import com.furnigo.iam.interfaces.rest.resources.CreateNewUserResource;
import com.furnigo.iam.interfaces.rest.resources.LoggedInUserResource;
import com.furnigo.iam.interfaces.rest.resources.LoginResource;
import com.furnigo.iam.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import com.furnigo.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.furnigo.iam.interfaces.rest.transform.LoggedInUserResourceFromEntityPairAssembler;

@RestController
@RequestMapping(value="/api/v1/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Authentication", description = "Authentication Endpoints")
public class AccountController {
    private final UserCommandService userCommandService;

    public AccountController(UserCommandService userCommandService ) {
        this.userCommandService = userCommandService;
    }

    /**
     * Handles the sign-in request.
     * @param resource the sign-in request body.
     * @return the authenticated user resource and the JWT token as a single resource.
     */
    @PostMapping("/login")
    @Transactional
    public ResponseEntity<LoggedInUserResource> login(@RequestBody LoginResource resource){
        // Convert the LoginResource to a SignInCommand
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(resource);

        // Handle the sign-in command and get the authenticated user
        var authenticatedUser = userCommandService.handle(signInCommand);

        // If the authenticated user is not present, return a 404 Not Found response
        if (authenticatedUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Convert the authenticated user to a LoggedInUserResource
        var loggedInUserResource = LoggedInUserResourceFromEntityPairAssembler
                .toResourceFromEntity(authenticatedUser.get().getLeft(), authenticatedUser.get().getRight());

        // Return the LoggedInUserResource with a 200 OK response
        return ResponseEntity.ok(loggedInUserResource);
    }

    /**
     * Handles the sign-up request.
     * @param resource The sign-up request body.
     * @return The authenticated user resource and the JWT token as a single resource.
     */
    @PostMapping("/sign-up")
    @Transactional
    public ResponseEntity<LoggedInUserResource> register(@RequestBody CreateNewUserResource resource){
        // Convert the CreateNewUserResource to a SignUpCommand
        var signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(resource);

        // Handle the sign-up command and get the authenticated user
        var authenticatedUser = userCommandService.handle(signUpCommand);

        // If there is an error, return a 400 Bad Request response.
        if (authenticatedUser.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Convert the authenticated user to a LoggedInUserResource
        var loggedInUserResource = LoggedInUserResourceFromEntityPairAssembler
                .toResourceFromEntity(authenticatedUser.get().getLeft(), authenticatedUser.get().getRight());

        // Return the LoggedInUserResource with a 200 OK response
        return ResponseEntity.ok(loggedInUserResource);
    }
}
