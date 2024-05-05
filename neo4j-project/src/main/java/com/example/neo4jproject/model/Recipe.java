package com.example.neo4jproject.model;

import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Node
@RequiredArgsConstructor
public class Recipe {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int preparationTime;
    private String skillLevel;
    private String description;
    private int cookingTime;
    @Relationship(type = "COLLECTION", direction = Relationship.Direction.OUTGOING)
    private List<Collection> collectionList = new ArrayList<>();
    @Relationship(type = "CONTAINS_INGREDIENT", direction = Relationship.Direction.OUTGOING)
    private List<Ingredient> ingredientList = new ArrayList<>();
    @Relationship(type = "KEYWORD", direction = Relationship.Direction.OUTGOING)
    private List<Keyword> keywordList = new ArrayList<>();

}
