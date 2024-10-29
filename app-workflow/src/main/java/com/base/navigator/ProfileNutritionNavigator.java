package com.base.navigator;

import com.base.strategy.impl.BuilderObjectCreateMealPlanToModuleIAStrategy;
import com.base.strategy.impl.RegisterProfileNutritionStrategy;
import com.base.strategy.impl.RegisterProfileNutritionToUserStrategy;
import com.base.strategy.impl.ValidateProfileNutritionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileNutritionNavigator extends NavigationApplication{

    @Autowired
    private ValidateProfileNutritionStrategy validateProfileNutritionStrategy;

    @Autowired
    private RegisterProfileNutritionStrategy registerProfileNutritionStrategy;

    @Autowired
    private RegisterProfileNutritionToUserStrategy registerProfileNutritionToUserStrategy;

    @Autowired
    private BuilderObjectCreateMealPlanToModuleIAStrategy builderObjectCreateMealPlanToModuleIAStrategy;

    public void registerNavigation() {
        navigatorExecute(validateProfileNutritionStrategy, registerProfileNutritionStrategy, registerProfileNutritionToUserStrategy);
    }

}
