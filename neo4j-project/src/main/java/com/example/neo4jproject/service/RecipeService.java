package com.example.neo4jproject.service;

import com.example.neo4jproject.DTO.RecipeDTO;
import com.example.neo4jproject.DTO.RecipeDTOMapper;
import com.example.neo4jproject.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    @Autowired
    private final RecipeRepository recipeRepository;
    @Autowired
    private final RecipeDTOMapper recipeInfo;

    public Page<RecipeDTO> getRecipesByPage(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("name").ascending());
        return recipeRepository.findAll(pageRequest).map(recipeInfo);
    }
}
