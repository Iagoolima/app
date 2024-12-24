package com.base.navigator;

import com.base.strategy.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MealPlanNavigator extends NavigationApplication {

    @Autowired
    private SendProfileNutritionModuleIAStrategy sendProfileNutritionModuleIAStrategy;

    @Autowired
    private ValidateFieldMealPlanFromModuleIAStrategy validateFieldMealPlanFromModuleIAStrategy;

    @Autowired
    private ValidateMappingMealAndMapperStrategy validateMappingMealAndMapperStrategy;

    @Autowired
    private RegisterPrimaryMealPlanStrategy registerPrimaryMealPlanStrategy;

    @Autowired
    private FindMealGeneratedStrategy findMealGeneratedStrategy;

    @Autowired
    private MapperConfirmMealPlanAndFindMealPlanStrategy mapperConfirmMealPlanAndFindMealPlanStrategy;

    @Autowired
    private RegisterTimerMealStrategy registerTimerMealStrategy;

    @Autowired
    private RemoveItemMealStrategy removeItemMealStrategy;

    @Autowired
    private SaveMealPlanStrategy saveMealPlanStrategy;

    @Autowired
    private ValidateMealPlanNotConfirmed validateMealPlanNotConfirmed;


    public void generateMealPlanNavigation(){
        navigatorExecute(sendProfileNutritionModuleIAStrategy, validateFieldMealPlanFromModuleIAStrategy,
                validateMappingMealAndMapperStrategy, registerPrimaryMealPlanStrategy);
    }

    public void findMealGeneratedNavigation(){
        navigatorExecute(validateMealPlanNotConfirmed, findMealGeneratedStrategy);
    }

    public void confirmMealPlan(){
        navigatorExecute(validateMealPlanNotConfirmed, mapperConfirmMealPlanAndFindMealPlanStrategy, registerTimerMealStrategy, removeItemMealStrategy, saveMealPlanStrategy);
    }
}
