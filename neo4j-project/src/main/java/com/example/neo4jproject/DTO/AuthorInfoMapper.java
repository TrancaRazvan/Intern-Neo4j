package com.example.neo4jproject.DTO;

import com.example.neo4jproject.model.Author;
import com.example.neo4jproject.model.Recipe;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Data
@Component
public class AuthorInfoMapper implements Function<Author, AuthorInfo> {
    @Override
    public AuthorInfo apply(Author author) {
        List<String> recipeNames = author.getRecipeList().stream().map(Recipe::getName).toList();
        return new AuthorInfo(
                author.getName(),
                recipeNames
        );
    }
}
