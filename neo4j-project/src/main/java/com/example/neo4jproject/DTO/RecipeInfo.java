package com.example.neo4jproject.DTO;

import com.example.neo4jproject.model.Collection;
import com.example.neo4jproject.model.DietType;
import com.example.neo4jproject.model.Ingredient;
import com.example.neo4jproject.model.Keyword;

import java.util.List;

public record RecipeInfo(
        String recipeName,
        String description,
        int cookingTime,
        int preparationTime,
        List<Ingredient> ingredientList,
        List<Collection> collectionList,
        List<Keyword> keywordList,
        List<DietType> dietTypeList
) {
}
