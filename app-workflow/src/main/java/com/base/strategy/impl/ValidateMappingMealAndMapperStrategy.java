package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.constants.MappingMealConstants;
import com.base.domain.MappingMeal;
import com.base.domain.MealPlan;
import com.base.dto.moduleIA.MealDtoResponse;
import com.base.dto.moduleIA.MealPlanDtoResponse;
import com.base.facade.mappingMealFacade.MappingMealFacade;
import com.base.mapper.impl.MealPlanMapper;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

import static com.base.business.application.Business.getSession;

@Component
public class ValidateMappingMealAndMapperStrategy implements IStrategy {

    @Autowired
    private MappingMealFacade facade;

    @Autowired
    private MappingMealConstants message;

    @Autowired
    private MealPlanMapper mapper;

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){

            MealPlanDtoResponse dto = business.getObject(MealPlanDtoResponse.class);

            List<MappingMeal> mappingMeals = facade.findAll();

            for(MealDtoResponse mealDto : dto.getMeals()){

                //validate if the meal exists on the mapping meals list
                MappingMeal matchingMeal = mappingMeals.stream()
                        .filter(mapping -> mapping.getId().equals(mealDto.getId()))
                        .findFirst()
                        .orElse(null);

                if(matchingMeal != null){

                    if(!mealDto.getMealName().equals(matchingMeal.getName())){
                        business.setError(MessageFormat.format(message.errorIncorrectCompareMealName, mealDto.getMealName(), matchingMeal.getName()), business.getUser().getId(), ValidateMappingMealAndMapperStrategy.class);
                    }
                }

            }

            if(!business.isError()){
                MealPlan mealPlan = mapper.toEntity(dto, business.getUser().getProfileNutrition());
                business.addObject(mealPlan);
            }

        }

    }
}
