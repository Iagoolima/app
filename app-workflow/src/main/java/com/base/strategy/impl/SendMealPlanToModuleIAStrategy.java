package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.strategy.IStrategy;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class SendMealPlanToModuleIAStrategy implements IStrategy {

    @Override
    public void execute() {

        Business business = getSession();


    }
}
