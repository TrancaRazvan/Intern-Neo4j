package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.DietType;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
public interface DietTypeRepository extends Neo4jRepository<DietType, Long> {
    @Query("MATCH (r:Recipe {name: $recipeName})-[:DIET_TYPE]->(d:DietType) RETURN d")
    List<DietType> findAllRecipesByName(String recipeName);
}
