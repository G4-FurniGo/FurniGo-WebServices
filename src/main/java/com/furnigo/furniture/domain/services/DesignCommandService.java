package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.commands.AcceptDesignCommand;
import com.furnigo.furniture.domain.model.commands.CreateDesignCommand;
import com.furnigo.furniture.domain.model.commands.WithdrawDesignCommand;

public interface DesignCommandService {
    Long handle(CreateDesignCommand command);
    Long handle(AcceptDesignCommand command);
    Long handle(WithdrawDesignCommand command);

}
