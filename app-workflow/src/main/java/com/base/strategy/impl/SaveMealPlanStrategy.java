package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.domain.MealPlan;
import com.base.facade.mealPlanFacade.MealPlanfacade;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class SaveMealPlanStrategy implements IStrategy {

    @Autowired
    private MealPlanfacade facade;

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            MealPlan mealPlan = business.getObject(MealPlan.class);
            facade.mealPlanRegisterOne(mealPlan);

        }

    }
}
