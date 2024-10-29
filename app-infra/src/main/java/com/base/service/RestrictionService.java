package com.base.service;

import com.base.domain.Restriction;
import com.base.repository.RestrictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestrictionService {

    @Autowired
    private RestrictionRepository repository;

    public List<Restriction> findAllById(List<Integer> listId) {

        List<Restriction> optionalRestriction = repository.findAllById(listId);

        if (optionalRestriction.isEmpty())
            throw new RuntimeException("Erro: Nenhuma restrição encontrada.");

        return optionalRestriction;
    }

}
