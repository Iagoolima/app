package com.base.facade.mealPlanFacade;

import com.base.domain.Meal;
import com.base.domain.MealPlan;
import com.base.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MealPlanFacade {

    @Autowired
    private MealPlanService service;

    public void registerPrimaryMealPlan(MealPlan mealPlan) {
        service.savePrimaryMealPlan(mealPlan);
    }

    public Meal findMeal(Integer idMeal, Integer idProfileNutrition){
        return service.findMeal(idMeal, idProfileNutrition);
    }

    public MealPlan findMealPlan(Integer idProfileNutrition){
        return service.findMealPlan(idProfileNutrition);
    }

    public void saveMealPlan(MealPlan mealPlan){
        service.save(mealPlan);
    }

    public Boolean findCompletedMealPlan(Integer idProfileNutrition){
        return service.findCompletedMealPlan(idProfileNutrition);
    }
}
