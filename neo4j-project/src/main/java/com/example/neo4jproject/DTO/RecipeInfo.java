package com.example.neo4jproject.DTO;

import com.example.neo4jproject.model.Ingredient;

import java.util.List;

public record RecipeInfo(
        String recipeName,
        String description,
        int cookingTime,
        int preparationTime,
        List<Ingredient> ingredientList
) {
}
