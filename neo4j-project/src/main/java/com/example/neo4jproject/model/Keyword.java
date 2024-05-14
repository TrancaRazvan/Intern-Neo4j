package com.example.neo4jproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@RequiredArgsConstructor
@Data
public class Keyword {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
