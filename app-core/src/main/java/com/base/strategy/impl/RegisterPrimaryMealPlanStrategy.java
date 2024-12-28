package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.domain.MealPlan;
import com.base.facade.mealPlanFacade.MealPlanFacade;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class RegisterPrimaryMealPlanStrategy implements IStrategy {

    @Autowired
    private MealPlanFacade facade;

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            MealPlan mealPlan = business.getObject(MealPlan.class);
            facade.registerPrimaryMealPlan(mealPlan);

        }

    }
}
