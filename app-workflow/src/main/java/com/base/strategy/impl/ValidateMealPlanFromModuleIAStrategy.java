package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.constants.ItemMealConstants;
import com.base.domain.MealPlan;
import com.base.dto.ItemMealDto;
import com.base.dto.MealDto;
import com.base.dto.MealPlanDto;
import com.base.mapper.impl.MealPlanMapper;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

import static com.base.business.application.Business.getSession;

@Component
public class ValidateMealPlanFromModuleIAStrategy implements IStrategy {

    @Autowired
    private ItemMealConstants fieldConst;

    @Autowired
    private MealPlanMapper mapper;

    private String error = "";

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            MealPlanDto dto = business.getObject(MealPlanDto.class);

            if(!dto.getMeals().isEmpty()) {
                for (MealDto meal : dto.getMeals()) {
                    for (ItemMealDto item : meal.getItems()) {
                        validateValueMealPlan(item.getCalories(), fieldConst.calories);
                        validateValueMealPlan(item.getFood(), fieldConst.food);
                        validateValueMealPlan(item.getDetails(), fieldConst.details);
                        validateValueMealPlan(item.getQuantity(), fieldConst.quantity);
                    }
                    validateValueMealPlan(meal.getMealName(), fieldConst.mealName);

                    if (!error.isEmpty()) {
                        business.setError(meal.getMealName() + "\n" + error);
                    }
                }

                if (!business.isError()) {
                    MealPlan mealPlan = mapper.toEntity(dto, business.getUser().getProfileNutrition());
                    business.addObject(mealPlan);
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

