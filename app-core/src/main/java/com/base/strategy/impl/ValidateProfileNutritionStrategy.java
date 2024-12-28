package com.base.strategy.impl;

import com.base.business.application.Business;
import com.base.constants.ProfileNutritionConstants;
import com.base.domain.ProfileNutrition;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class ValidateProfileNutritionStrategy implements IStrategy {

    @Autowired
    private ProfileNutritionConstants message;

    @Override
    public void execute() {

        Business business = getSession();

        if(!(business.getUser().getProfileNutrition() == null)) {
            business.setError(message.profileNutritionRegister, business.getUser().getId(), ValidateProfileNutritionStrategy.class);
        }

        ProfileNutrition profileNutrition = business.getObject(ProfileNutrition.class);

        // Validates if the desired weight is not overly unrealistic
        double limitPercentage = 0.30;
        double acceptableWeightLower = profileNutrition.getWeight() - (profileNutrition.getWeight() * limitPercentage);
        double acceptableWeightUpper = profileNutrition.getWeight() + (profileNutrition.getWeight() * limitPercentage);

        double desiredWeight = profileNutrition.getDesiredWeight();

        if (desiredWeight < acceptableWeightLower) {
            business.setError(message.weightTooLow);
        } else if (desiredWeight > acceptableWeightUpper) {
            business.setError(message.weightTooHigh);
        }

    }
}
