package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.constants.MealPlanConstants;
import com.base.domain.Meal;
import com.base.domain.MealPlan;
import com.base.dto.ClassGeneric;
import com.base.facade.mealPlanFacade.MealPlanFacade;
import com.base.mapper.impl.MealMapper;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class FindMealGeneratedStrategy implements IStrategy {

    @Autowired
    private MealPlanFacade facade;

    @Autowired
    private MealMapper mapper;

    @Autowired
    private MealPlanConstants message;

    @Override
    public void execute() {

        Business business = getSession();
        Integer idMeal = (Integer) business.getObject(ClassGeneric.class).getValue();

        MealPlan mealPlan = facade.findMealPlan(business.getUser().getProfileNutrition().getId());

        Meal meal = mealPlan.getMeals().stream()
                .filter(m -> m.getIdMappingMeal().getId().equals(idMeal))
                .findFirst()
                .orElse(null);

        if(meal != null) {
            business.addObject(mapper.toDtoFindMealGeneratedDtoResponse(mealPlan.getId(),  meal));
        }else{
            business.setError(message.errorFindMeal, business.getUser().getId(), FindMealGeneratedStrategy.class);
        }

    }
}
