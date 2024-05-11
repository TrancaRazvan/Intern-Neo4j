package com.example.neo4jproject.DTO;

public record RecipeWithAuthor(
         String recipeName,
         String authorName,
         int numberOfIngredients,
         String skillLevel) {
}
