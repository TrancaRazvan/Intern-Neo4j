package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.Ingredient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IngredientRepository extends Neo4jRepository<Ingredient, Long> {
}
