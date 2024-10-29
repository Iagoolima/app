package com.base.controller.impl;

import com.base.controller.BaseController;
import com.base.controller.ICrudController;
import com.base.processor.MealPlanProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class MealPlanController extends BaseController implements ICrudController {

    @Autowired
    private MealPlanProcessor processor;

    @Override
    public ResponseEntity register(Object dto) {
        return processor.registerProcessor();
    }

    @Override
    public ResponseEntity update(Object dto) {
        return null;
    }

    @Override
    public ResponseEntity delete(Object dto) {
        return null;
    }

    @Override
    public ResponseEntity find(Object dto) {
        return null;
    }
}
