package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.Collection;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CollectionRepository extends Neo4jRepository<Collection, Long> {
}
