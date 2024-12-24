package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.constants.MealPlanConstants;
import com.base.domain.*;
import com.base.facade.mappingMealFacade.MappingMealFacade;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.LocalTime;
import java.util.List;

import static com.base.business.application.Business.getSession;

@Component
public class RegisterTimerMealStrategy implements IStrategy {

    @Autowired
    private MealPlanConstants message;

    @Autowired
    private MappingMealFacade facade;

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            MealPlan mealPlan = business.getObject(MealPlan.class);
            ConfirmMealPlan confirmMealPlan = business.getObject(ConfirmMealPlan.class);

            List<MappingMeal> ListMappingMeal = facade.findAll();

            for (Meal meal : mealPlan.getMeals()) {

                //filter Meal to compare if it is the same with the database
                ConfirmMeal matchingConfirmMeal = confirmMealPlan.getMeals().stream()
                        .filter(confirmMeal -> meal.getId().equals(confirmMeal.getIdMeal()))
                        .findFirst()
                        .orElse(null);

                if (matchingConfirmMeal != null) {

                    ////filters the meal mapping to validate if the time entered is between the range.
                    MappingMeal mappingMeal = ListMappingMeal.stream()
                            .filter(m -> m.getId().equals(meal.getIdMappingMeal().getId()))
                            .findFirst()
                            .orElse(null);

                    if(mappingMeal != null){

                        if (isTimeWithinRange(matchingConfirmMeal.getTimer(), mappingMeal.getTimerInit(), mappingMeal.getTimerEnd())) {
                            meal.setTime(matchingConfirmMeal.getTimer());
                        } else {
                            business.setError(
                                    MessageFormat.format(message.errorInvalidTime, meal.getMealName(), matchingConfirmMeal.getTimer(),mappingMeal.getTimerInit(), mappingMeal.getTimerEnd()));
                            break;
                        }

                    } else {
                        business.setError(message.errorFilterMappingMeal, business.getUser().getId(), RegisterTimerMealStrategy.class);
                    }

                } else{
                    business.setError(message.errorFilterMeal, business.getUser().getId(), RegisterTimerMealStrategy.class);
                }

            }

        }

    }

    private boolean isTimeWithinRange(LocalTime timerInsertion, LocalTime timerInit, LocalTime timerEnd) {
        return timerInsertion != null &&
                !timerInsertion.isBefore(timerInit) &&
                !timerInsertion.isAfter(timerEnd);
    }

}
