package com.furnigo.iam.interfaces.rest.transform;

import com.furnigo.iam.domain.model.commands.SignInCommand;
import com.furnigo.iam.interfaces.rest.resources.LoginResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(LoginResource loginResource) {
        return new SignInCommand(loginResource.email(), loginResource.password());
    }
}
