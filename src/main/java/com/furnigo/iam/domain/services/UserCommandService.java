package com.furnigo.iam.domain.services;


import com.furnigo.iam.domain.model.commands.SignInCommand;
import com.furnigo.iam.domain.model.commands.SignUpCommand;
import com.furnigo.iam.domain.model.entities.User;
import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<ImmutablePair<User, String>> handle(SignUpCommand command);
}
