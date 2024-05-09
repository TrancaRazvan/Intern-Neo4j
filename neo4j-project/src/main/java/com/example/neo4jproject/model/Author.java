package com.example.neo4jproject.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
@NoArgsConstructor
public class Author {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "WROTE", direction = Relationship.Direction.OUTGOING)
    private List<Recipe> recipeList = new ArrayList<>();

}
