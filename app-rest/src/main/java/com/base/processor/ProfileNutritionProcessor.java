package com.base.processor;

import com.base.business.application.Business;
import com.base.dto.RegisterProfileNutritionDtoRequest;
import com.base.mapper.impl.RegisterProfileNutritionMapper;
import com.base.navigator.ProfileNutritionNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class ProfileNutritionProcessor {

    @Autowired
    private ProfileNutritionNavigator navigation;

    @Autowired
    private RegisterProfileNutritionMapper registerProfileNutritionMapper;

    public ResponseEntity<?> registerProcessor(RegisterProfileNutritionDtoRequest dto) {

        Business business = getSession();
        business.addObject(registerProfileNutritionMapper.toDomain(dto));

        navigation.registerNavigation();

        if(business.isError()){
            return ResponseEntity.badRequest().body(business.getMessageError());
        }
        return ResponseEntity.ok().build();
    }
}
