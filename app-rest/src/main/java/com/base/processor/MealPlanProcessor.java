package com.base.processor;

import com.base.business.application.Business;
import com.base.navigator.MealPlanNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static com.base.business.application.Business.getSession;

public class MealPlanProcessor {

    @Autowired
    private MealPlanNavigator navigator;

    public ResponseEntity<?> registerProcessor(){

        Business business = getSession();

        return null;

    }
}
