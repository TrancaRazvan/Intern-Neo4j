package com.example.neo4jproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
@RequiredArgsConstructor
@Data
public class DietType {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Relationship(type = "DIET_TYPE", direction = Relationship.Direction.INCOMING)
    private List<Recipe> recipeList = new ArrayList<>();
}
