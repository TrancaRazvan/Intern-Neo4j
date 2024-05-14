package com.example.neo4jproject.repository;

import com.example.neo4jproject.DTO.AuthorInfo;
import com.example.neo4jproject.model.Author;
import com.example.neo4jproject.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends Neo4jRepository<Author, Long> {
    @Query("MATCH (a:Author)-[:WROTE]->(r:Recipe {name: $recipeName}) RETURN a")
    Author findByRecipesName(String recipeName);
    Page<Author> findAllRecipesByName(Pageable pageable, String authorName);
}
