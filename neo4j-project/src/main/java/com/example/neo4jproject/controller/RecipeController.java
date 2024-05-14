package com.example.neo4jproject.controller;

import com.example.neo4jproject.DTO.RecipeInfo;
import com.example.neo4jproject.DTO.RecipeWithAuthor;
import com.example.neo4jproject.model.Recipe;
import com.example.neo4jproject.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private final RecipeService recipeService;

    @GetMapping("/page/{pageNumber}")
    public String getRecipesByPage(Model model, @PathVariable Optional<Integer> pageNumber) {
        int pageSize = 20;
        Page<RecipeWithAuthor> recipes = recipeService.getRecipesByPage(pageNumber.orElse(0), pageSize);
        model.addAttribute("recipes", recipes);
        return "index.html";
    }

    @GetMapping("/{name}")
    public String getRecipeInformation(@PathVariable String name, Model model) {
        RecipeInfo recipe = recipeService.getRecipeByName(name);
        if (recipe != null) {
            model.addAttribute("recipes", recipe);
            return "recipe-info.html";
        } else return "error.html";
    }

    @GetMapping("/search-by-name/page/{pageNumber}/{keyword}")
    public String getRecipesByName(Model model, @PathVariable Optional<Integer> pageNumber, @PathVariable String keyword) {
        int pageSize = 20;
        Page<RecipeWithAuthor> recipes = recipeService.getRecipesByKeyword(pageNumber.orElse(0), pageSize, keyword);
        model.addAttribute("recipes", recipes);
        return "index.html";
    }

    @GetMapping("/search-by-ingredient/{keyword}")
    public String getRecipeByIngredientName(@PathVariable String keyword, Model model){
        List<Recipe> recipes = recipeService.findRecipeByIngredientName(keyword);
        model.addAttribute("recipes", recipes);
        return "find-recipe-by-ingredient.html";
    }
}