package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.constants.MealPlanConstants;
import com.base.domain.ConfirmMealPlan;
import com.base.domain.MealPlan;
import com.base.dto.ConfirmMealPlanDtoRequest;
import com.base.facade.mealPlanFacade.MealPlanFacade;
import com.base.mapper.impl.ConfirmMealPlanMapper;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class MapperConfirmMealPlanAndFindMealPlanStrategy implements IStrategy {

    @Autowired
    private ConfirmMealPlanMapper mapper;

    @Autowired
    private MealPlanFacade facade;

    @Autowired
    private MealPlanConstants message;

    @Override
    public void execute() {

        Business business = getSession();
        ConfirmMealPlan confirmMealPlan = mapper.toDomain(business.getObject(ConfirmMealPlanDtoRequest.class));

        MealPlan mealPlan = facade.findMealPlan(business.getUser().getProfileNutrition().getId());
        mealPlan.setCompleted(true);

        if(mealPlan == null)
            business.setError(message.errorFindMealPlan, business.getUser().getId(), MapperConfirmMealPlanAndFindMealPlanStrategy.class);

        if( mealPlan != null && !mealPlan.getId().equals(confirmMealPlan.getIdMealPlan()))
            business.setError(message.errorEqualsValueMealPlan, business.getUser().getId(), MapperConfirmMealPlanAndFindMealPlanStrategy.class);


        business.addObject(confirmMealPlan);
        business.addObject(mealPlan);

    }
}
