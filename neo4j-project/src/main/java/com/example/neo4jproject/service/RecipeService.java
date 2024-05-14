package com.example.neo4jproject.service;

import com.example.neo4jproject.DTO.RecipeInfo;
import com.example.neo4jproject.DTO.RecipeInfoMapper;
import com.example.neo4jproject.DTO.RecipeWithAuthor;
import com.example.neo4jproject.DTO.RecipeWithAuthorMapper;
import com.example.neo4jproject.model.Recipe;
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
    private final RecipeWithAuthorMapper recipeWithAuthorMapper;
    @Autowired
    private final RecipeInfoMapper recipeInfoMapper;

    public Page<RecipeWithAuthor> getRecipesByPage(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("name").ascending());
        return recipeRepository.findAll(pageRequest).map(recipeWithAuthorMapper);
    }

    public RecipeInfo getRecipeByName(String name) {
        Recipe recipe = recipeRepository.findByName(name);
        if (recipe != null) {
            return recipeInfoMapper.apply(recipe);
        } else return null;
    }
    public Page<RecipeWithAuthor> getRecipesByKeyword(int pageNumber, int pageSize, String keyword) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("name").ascending());
        return recipeRepository.findByNameContaining(pageRequest, keyword).map(recipeWithAuthorMapper);
    }

    //Requirement 4,
//    public Page<Recipe> findRecipesByIngredient(String ingredientName, int pageNumber, int pageSize) {
//        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
//        return recipeRepository.findByIngredientName(pageRequest, ingredientName);
//    }

}
