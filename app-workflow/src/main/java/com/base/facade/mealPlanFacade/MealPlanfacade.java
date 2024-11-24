package com.base.facade.mealPlanFacade;

import com.base.domain.MealPlan;
import com.base.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MealPlanfacade {

    @Autowired
    private MealPlanService service;

    public void mealPlanRegisterOne(MealPlan mealPlan) {
        service.save(mealPlan);
    }
}
