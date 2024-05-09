package com.example.neo4jproject.DTO;

import com.example.neo4jproject.model.Recipe;
import com.example.neo4jproject.service.AuthorService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Data
@Component
public class RecipeDTOMapper implements Function<Recipe, RecipeDTO> {

    private final AuthorService authorService;

    @Override
    public RecipeDTO apply(Recipe recipe) {
        return new RecipeDTO(
                recipe.getName(),
                authorService.setAuthorToRecipe(recipe),
                recipe.getIngredientList().size(),
                recipe.getSkillLevel());
    }
}
