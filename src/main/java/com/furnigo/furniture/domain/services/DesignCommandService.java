package com.furnigo.furniture.domain.services;


public interface DesignCommandService {
    Long handle(CreateDesignCommand command);
    Long handle(AcceptDesignCommand command);
    Long handle(WithdrawDesignCommand command);

}
