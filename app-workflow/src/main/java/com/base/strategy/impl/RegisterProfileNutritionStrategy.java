package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.domain.ProfileNutrition;
import com.base.facade.profileNutritionFacade.ProfileNutritionFacade;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class RegisterProfileNutritionStrategy implements IStrategy {

    @Autowired
    private ProfileNutritionFacade facade;

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            ProfileNutrition profileNutrition = business.getObject(ProfileNutrition.class);

            ProfileNutrition profileNutritionData = facade.RegisterProfileNutrition(profileNutrition);

            business.addObject(profileNutritionData);
        }

    }
}
