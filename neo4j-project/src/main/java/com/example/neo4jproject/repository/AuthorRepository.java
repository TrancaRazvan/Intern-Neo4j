package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.Author;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface AuthorRepository extends Neo4jRepository<Author, Long> {
    @Query("MATCH (n:Author) RETURN n LIMIT 25")
    List<Author> findTopNAuthors(int limit);
}
