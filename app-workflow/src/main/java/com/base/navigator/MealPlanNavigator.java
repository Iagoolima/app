package com.base.navigator;

import com.base.strategy.impl.SendDataModuleIAStrategy;
import com.base.strategy.impl.ValidateMealPlanFromModuleIAStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MealPlanNavigator extends NavigationApplication {

    @Autowired
    private SendDataModuleIAStrategy sendDataModuleIAStrategy;

    @Autowired
    private ValidateMealPlanFromModuleIAStrategy validateMealPlanFromModuleIAStrategy;

    public void generateMealPlanNavigation(){
        navigatorExecute(sendDataModuleIAStrategy, validateMealPlanFromModuleIAStrategy);
    }
}
