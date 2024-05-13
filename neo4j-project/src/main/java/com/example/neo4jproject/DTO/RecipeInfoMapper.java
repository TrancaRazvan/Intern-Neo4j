package com.example.neo4jproject.DTO;

import com.example.neo4jproject.model.Recipe;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Data
public class RecipeInfoMapper implements Function<Recipe, RecipeInfo> {
    @Override
    public RecipeInfo apply(Recipe recipe) {
        return new RecipeInfo(
                recipe.getName(),
                recipe.getDescription(),
                recipe.getCookingTime(),
                recipe.getPreparationTime(),
                recipe.getIngredientList()
        );
    }

}
