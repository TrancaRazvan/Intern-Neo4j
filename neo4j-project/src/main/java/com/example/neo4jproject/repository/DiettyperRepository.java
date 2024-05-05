package com.example.neo4jproject.repository;

import com.example.neo4jproject.model.Diettype;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DiettyperRepository extends Neo4jRepository<Diettype, Long> {
}
