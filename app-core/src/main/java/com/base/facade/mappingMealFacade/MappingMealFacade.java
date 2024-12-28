package com.base.facade.mappingMealFacade;

import com.base.domain.MappingMeal;
import com.base.service.MappingMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MappingMealFacade {

    @Autowired
    private MappingMealService service;

    public List<MappingMeal> findAll(){
        return service.findAll();
    }

}
