package com.base.core.strategy.impl;

import com.base.business.application.Business;
import com.base.core.business.impl.GeneratedAcessTokenBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.service.security.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GeneratedAcessTokenStrategy implements IStrategy {

    @Autowired
    private AuthUserFacade facade;

    @Autowired
    private JwtServiceImpl jwtService;

    @Override
    public void execute() {

        Business business = Business.getSession();

        if(!business.isError()){
            //gerar refresh token com base no usuario logado
        }

    }

}
