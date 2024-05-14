package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.Ingredient;
import com.example.neo4jproject.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IngredientRepository extends Neo4jRepository<Ingredient, Long> {

}
