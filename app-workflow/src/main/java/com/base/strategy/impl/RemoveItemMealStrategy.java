package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.domain.ConfirmMealPlan;
import com.base.domain.MealPlan;
import com.base.strategy.IStrategy;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class RemoveItemMealStrategy implements IStrategy {

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            MealPlan mealPlan = business.getObject(MealPlan.class);
            ConfirmMealPlan confirmMealPlan = business.getObject(ConfirmMealPlan.class);

            confirmMealPlan.getMeals().forEach(confirmMeal ->
                    confirmMeal.getItems().stream()
                            .filter(confirmItemMeal -> !Boolean.TRUE.equals(confirmItemMeal.getConfirm()))
                            .forEach(confirmItemMeal ->
                                    mealPlan.getMeals().forEach(meal ->
                                            meal.getItems().removeIf(item -> item.getId().equals(confirmItemMeal.getIdItemMeal()))
                                    )
                            )
            );

        }

    }
}
