package com.base.mapper.impl;

import com.base.domain.ConfirmItemMeal;
import com.base.domain.ConfirmMeal;
import com.base.domain.ConfirmMealPlan;
import com.base.dto.ConfirmItemMealDtoRequest;
import com.base.dto.ConfirmMealDtoRequest;
import com.base.dto.ConfirmMealPlanDtoRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConfirmMealPlanMapper {

    public ConfirmMealPlan toDomain(ConfirmMealPlanDtoRequest dtoRequest) {
        if (dtoRequest == null) {
            return null;
        }
        ConfirmMealPlan domain = new ConfirmMealPlan();

        domain.setIdMealPlan(dtoRequest.getIdMealPlan());

        List<ConfirmMeal> domainMeals = new ArrayList<>();
        if (dtoRequest.getMeals() != null) {

            for (ConfirmMealDtoRequest mealDto : dtoRequest.getMeals()) {
                ConfirmMeal meal = new ConfirmMeal();
                meal.setIdMeal(mealDto.getIdMeal());
                meal.setTimer(mealDto.getTimer());

                List<ConfirmItemMeal> domainItems = new ArrayList<>();

                if (mealDto.getItems() != null) {
                    for (ConfirmItemMealDtoRequest itemDto : mealDto.getItems()) {
                        ConfirmItemMeal item = new ConfirmItemMeal();
                        item.setIdItemMeal(itemDto.getIdItemMeal());
                        item.setConfirm(itemDto.getConfirm());
                        domainItems.add(item);
                    }
                }
                meal.setItems(domainItems);
                domainMeals.add(meal);
            }
        }
        domain.setMeals(domainMeals);

        return domain;
    }

}
