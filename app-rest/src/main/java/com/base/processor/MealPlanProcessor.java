package com.base.processor;

import com.base.business.application.Business;
import com.base.dto.ClassGeneric;
import com.base.dto.ConfirmMealPlanDtoRequest;
import com.base.dto.FindMealGeneratedDtoResponse;
import com.base.dto.moduleIA.ProfileNutritionToModuleIADtoRequest;
import com.base.navigator.MealPlanNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class MealPlanProcessor {

    @Autowired
    private MealPlanNavigator navigation;

    public ResponseEntity<?> registerProcessor(){

        Business business = getSession();
        business.addObject(new ProfileNutritionToModuleIADtoRequest(business.getUser().getName(), business.getUser().getProfileNutrition()));

        navigation.generateMealPlanNavigation();

        if(business.isError()){
            return ResponseEntity.badRequest().body(business.getMessageError());
        } else {
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<?> findFromValidateMeal(Integer idMappingMeal){

        Business business = getSession();
        business.addObject(new ClassGeneric<>(idMappingMeal));

        navigation.findMealGeneratedNavigation();

        if(business.isError()){
            return ResponseEntity.badRequest().body(business.getMessageError());
        } else {
            return ResponseEntity.ok(business.getObject(FindMealGeneratedDtoResponse.class));
        }
    }

    public ResponseEntity<?> confirmMealPlan(ConfirmMealPlanDtoRequest dto){

        Business business = getSession();
        business.addObject(dto);

        navigation.confirmMealPlan();

        if(business.isError()){
            return ResponseEntity.badRequest().body(business.getMessageError());
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
