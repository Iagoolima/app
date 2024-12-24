package com.base.domainMock;

import com.base.domain.Focus;
import com.base.domain.ProfileNutrition;
import com.base.domain.Restriction;
import com.base.dto.moduleIA.ProfileNutritionToModuleIADtoRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileNutritionMock {

    @Bean
    public ProfileNutritionToModuleIADtoRequest valueCorrect() {

        ProfileNutrition profileNutrition = new ProfileNutrition();

        profileNutrition.setAge(21);
        profileNutrition.setDesiredWeight(70);
        profileNutrition.setHeight(180);
        profileNutrition.setWeight(82);
        profileNutrition.setGender('M');
        profileNutrition.setInsertionDate(LocalDateTime.now());

        Focus focus = new Focus();
        focus.setId(2);
        focus.setName("Ganho de Massa Muscular");
        focus.setInsertionDate(LocalDateTime.now());
        profileNutrition.setFocus(focus);

        List<Restriction> restrictions = new ArrayList<>();

        Restriction restriction = new Restriction();
        restriction.setId(4);
        restriction.setName("Alergia ao Glúten");
        restriction.setInsertionDate(LocalDateTime.now());
        restrictions.add(restriction);

        profileNutrition.setRestrictions(restrictions);

        ProfileNutritionToModuleIADtoRequest profileNutritionToModuleIADtoRequest = new ProfileNutritionToModuleIADtoRequest("João Souza", profileNutrition);

        return profileNutritionToModuleIADtoRequest;

    }

}
