package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.Keyword;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface KeywordRepository extends Neo4jRepository<Keyword, Long> {
}
