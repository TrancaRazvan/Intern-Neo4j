package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends Neo4jRepository<Recipe, Long> {
//    @Query("MATCH (author:Author)-[:WROTE]->(recipe:Recipe)" +
//            "OPTIONAL MATCH (recipe)-[:CONTAINS_INGREDIENT]->(ingredient)" +
//            "RETURN recipe.name AS recipeName, author.name AS authorName, COUNT(ingredient) AS numberOfIngredients, recipe.skillLevel AS skillLevel ORDER BY TRIM(recipe.name)")
//    Page<RecipeInfo> findRecipesWithDetails();
Page<Recipe> findAll(Pageable pageable);
}
