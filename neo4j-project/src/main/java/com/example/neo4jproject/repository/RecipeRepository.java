package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.Recipe;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RecipeRepository extends Neo4jRepository<Recipe, Long> {
}
