package com.example.neo4jproject.DTO;

public record RecipeDTO(
         String recipeName,
         String authorName,
         int numberOfIngredients,
         String skillLevel) {
}
