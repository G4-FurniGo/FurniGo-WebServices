package com.furnigo.iam.interfaces.rest.transform;

import com.furnigo.iam.domain.model.entities.User;
import com.furnigo.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntity {
    public static UserResource fromEntity(User user) {
        return new UserResource(
            user.getId(),
            user.getName(),
            user.getLastName(),
            user.getProfilePicture(),
            user.getRole().toString(),
            user.getEmail(),
            user.getPhone()
        );
    }
}
