package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.constants.ItemMealConstants;
import com.base.domain.ItemMeal;
import com.base.domain.Meal;
import com.base.dto.ModuleIAToMealPlanDTO;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

import static com.base.business.application.Business.getSession;

@Component
public class ValidateMealPlanFromModuleIAStrategy implements IStrategy {

    @Autowired
    private ItemMealConstants fieldConst;

    private String error = "";

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            ModuleIAToMealPlanDTO dto = business.getObject(ModuleIAToMealPlanDTO.class);

            if(!dto.getMeals().isEmpty()) {
                for (Meal meal : dto.getMeals()){
                    for(ItemMeal item : meal.getItems()){
                        validateValueMealPlan(item.getCalories(), fieldConst.calories);
                        validateValueMealPlan(item.getFood(), fieldConst.food);
                        validateValueMealPlan(item.getDetails(), fieldConst.details);
                        validateValueMealPlan(item.getQuantity(), fieldConst.quantity);
                    }

                    if(!error.isEmpty()){
                        business.setError(meal.getMealName() + "\n" + error);
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
            if (value == null || ((String) value).isBlank()){
                this.error += MessageFormat.format(fieldConst.error, value, field);;
            }
        }

    }
}

