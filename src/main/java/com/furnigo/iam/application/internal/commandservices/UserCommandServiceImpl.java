package com.furnigo.iam.application.internal.commandservices;

import com.furnigo.iam.application.internal.outboundservices.hashing.HashingService;
import com.furnigo.iam.application.internal.outboundservices.tokens.TokenService;
import com.furnigo.iam.domain.model.commands.SignInCommand;
import com.furnigo.iam.domain.model.commands.SignUpCommand;
import com.furnigo.iam.domain.model.entities.User;
import com.furnigo.iam.domain.model.valueobjects.UserRole;
import com.furnigo.iam.domain.services.UserCommandService;
import com.furnigo.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService,
                                  TokenService tokenService) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
    }
    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user  = userRepository.findByEmail(command.email());

        if (user.isEmpty()){
            throw new RuntimeException("User not found");
        }

        if (!hashingService.matches(command.password(), user.get().getPassword())){
            throw new RuntimeException("Invalid password");
        }

        var token = tokenService.generateToken(user.get().getEmail());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignUpCommand command) {
        if (userRepository.existsByEmail(command.email())){
            throw new RuntimeException("An user with the same email already exists.");
        }
        var user = new User(
                command.name(),
                command.lastName(),
                command.pic(),
                Objects.equals(command.role().toUpperCase(), "CLIENT") ? UserRole.CLIENT : UserRole.EXPERT,
                command.email(),
                command.phone(),
                hashingService.encode(command.password())
        );
        userRepository.save(user);
        var token = tokenService.generateToken(user.getEmail());
        return Optional.of(ImmutablePair.of(user, token));

    }
}
