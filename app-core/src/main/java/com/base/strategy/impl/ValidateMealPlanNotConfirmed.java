package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.constants.MealPlanConstants;
import com.base.facade.mealPlanFacade.MealPlanFacade;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class ValidateMealPlanNotConfirmed implements IStrategy {

    @Autowired
    private MealPlanFacade facade;

    @Autowired
    private MealPlanConstants message;

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

           Integer idProfileNutrition = business.getUser().getProfileNutrition().getId();

           if(facade.findCompletedMealPlan(idProfileNutrition)){
               business.setError(message.mealPlanCompleted);
           }

        }
    }
}
