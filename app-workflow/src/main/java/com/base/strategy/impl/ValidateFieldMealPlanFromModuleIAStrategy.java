package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.constants.ItemMealConstants;
import com.base.constants.MealPlanConstants;
import com.base.dto.moduleIA.ItemMealDto;
import com.base.dto.moduleIA.MealDtoResponse;
import com.base.dto.moduleIA.MealPlanDtoResponse;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

import static com.base.business.application.Business.getSession;

@Component
public class ValidateFieldMealPlanFromModuleIAStrategy implements IStrategy {

    @Autowired
    private ItemMealConstants fieldConst;

    @Autowired
    private MealPlanConstants message;

    private String error = "";

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            MealPlanDtoResponse dto = business.getObject(MealPlanDtoResponse.class);

            if(!dto.getMeals().isEmpty()) {
                for (MealDtoResponse meal : dto.getMeals()) {
                    for (ItemMealDto item : meal.getItems()) {
                        validateValueMealPlan(item.getCalories(), fieldConst.calories);
                        validateValueMealPlan(item.getFood(), fieldConst.food);
                        validateValueMealPlan(item.getDetails(), fieldConst.details);
                        validateValueMealPlan(item.getQuantity(), fieldConst.quantity);
                    }
                    validateValueMealPlan(meal.getMealName(), fieldConst.mealName);

                    if (!error.isEmpty()) {
                        business.setError(meal.getMealName() + "\n" + error, business.getUser().getId(), ValidateFieldMealPlanFromModuleIAStrategy.class);
                        business.setError(message.valueNullMealPlan);
                    }
                }

            }
        }
    }

    public <T> void validateValueMealPlan(T value, String field) {
        if (value instanceof Integer) {
            if((Integer)value == 0){
                this.error += MessageFormat.format(fieldConst.error, value, field);;
            }
        }

        if (value instanceof String) {
            if (((String) value).isEmpty() || ((String) value).isBlank()){
                this.error += MessageFormat.format(fieldConst.error, value, field);;
            }
        }

    }
}

