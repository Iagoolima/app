package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.domain.ProfileNutritionToMealPlan;
import com.base.domain.ProfileNutrition;
import com.base.strategy.IStrategy;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class BuilderObjectCreateMealPlanToModuleIAStrategy implements IStrategy {

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            String nameUser = business.getUser().getName();
            ProfileNutrition profileNutrition = business.getObject(ProfileNutrition.class);

            business.addObject(new ProfileNutritionToMealPlan(nameUser, profileNutrition));
        }
    }
}
