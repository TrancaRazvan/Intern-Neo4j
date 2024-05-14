package com.example.neo4jproject.DTO;

import com.example.neo4jproject.model.Recipe;
import org.springframework.data.domain.Page;

import java.util.List;

public record AuthorInfo(
        String name,
        List<String> recipeList
) {
}
