package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends Neo4jRepository<Recipe, Long> {
    Page<Recipe> findAll(Pageable pageable);

    Recipe findByName(String name);

    Page<Recipe> findByNameContaining(Pageable pageable, String keyword);

    //Requirement 4,
//    @Query(value = "MATCH (r:Recipe)-[:CONTAINS_INGREDIENT]->(i:Ingredient) WHERE i.name = $ingredientName RETURN r",
//            countQuery = "MATCH (r:Recipe)-[:CONTAINS_INGREDIENT]->(i:Ingredient) WHERE i.name = $ingredientName RETURN count(r)")
//    Page<Recipe> findByIngredientName(Pageable pageable, String ingredientName);
}
