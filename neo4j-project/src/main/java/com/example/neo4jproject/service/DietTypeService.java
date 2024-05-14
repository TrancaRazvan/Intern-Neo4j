package com.example.neo4jproject.service;

import com.example.neo4jproject.model.DietType;
import com.example.neo4jproject.repository.DietTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DietTypeService {
    @Autowired
    private final DietTypeRepository dietTypeRepository;

    public List<DietType> getDietTypesByRecipeName(String recipeName){
        return dietTypeRepository.findAllRecipesByName(recipeName);
    }
}
