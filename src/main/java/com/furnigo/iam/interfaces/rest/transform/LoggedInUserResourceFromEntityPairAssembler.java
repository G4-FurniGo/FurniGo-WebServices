package com.furnigo.iam.interfaces.rest.transform;

import com.furnigo.iam.domain.model.entities.User;
import com.furnigo.iam.interfaces.rest.resources.LoggedInUserResource;
import com.furnigo.iam.interfaces.rest.resources.UserResource;

public class LoggedInUserResourceFromEntityPairAssembler {
    public static LoggedInUserResource toResourceFromEntity(User left, String right) {
        var userResource = new UserResource(
                left.getId(),
                left.getName(),
                left.getLastName(),
                left.getProfilePicture(),
                left.getRole().toString(),
                left.getEmail(),
                left.getPhone()
        );
        return new LoggedInUserResource(userResource, right);
    }
}
