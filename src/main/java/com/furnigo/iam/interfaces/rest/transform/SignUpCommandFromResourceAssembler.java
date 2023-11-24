package com.furnigo.iam.interfaces.rest.transform;

import com.furnigo.iam.domain.model.commands.SignUpCommand;
import com.furnigo.iam.interfaces.rest.resources.CreateNewUserResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(CreateNewUserResource signUpResource) {
        return new SignUpCommand(signUpResource.name(), signUpResource.lastName(), signUpResource.email(), signUpResource.password());
    }
}
