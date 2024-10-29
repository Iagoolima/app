package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.domain.ProfileNutrition;
import com.base.domain.User;
import com.base.facade.userFacade.UserFacade;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class RegisterProfileNutritionToUserStrategy implements IStrategy {

    @Autowired
    private UserFacade facade;

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){
            ProfileNutrition profileNutrition = business.getObject(ProfileNutrition.class);
            User user = business.getUser();
            user.setProfileNutrition(profileNutrition);

            facade.updateUser(user);

        }

    }
}
