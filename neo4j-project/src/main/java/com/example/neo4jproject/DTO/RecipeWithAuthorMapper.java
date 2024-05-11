package com.example.neo4jproject.DTO;

import com.example.neo4jproject.model.Recipe;
import com.example.neo4jproject.service.AuthorService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Data
@Component
public class RecipeWithAuthorMapper implements Function<Recipe, RecipeWithAuthor> {

    private final AuthorService authorService;

    @Override
    public RecipeWithAuthor apply(Recipe recipe) {
        return new RecipeWithAuthor(
                recipe.getName(),
                authorService.setAuthorToRecipe(recipe),
                recipe.getIngredientList().size(),
                recipe.getSkillLevel());
    }
}
