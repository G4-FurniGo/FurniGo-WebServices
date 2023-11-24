package com.furnigo.iam.interfaces.rest.transform;

import com.furnigo.iam.domain.model.commands.SignUpCommand;
import com.furnigo.iam.interfaces.rest.resources.CreateNewUserResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(CreateNewUserResource signUpResource) {
        return new SignUpCommand(
                signUpResource.email(),
                signUpResource.password(),
                signUpResource.name(),
                signUpResource.lastName(),
                signUpResource.role(),
                signUpResource.phone(),
                signUpResource.pic()
        );
    }
}
