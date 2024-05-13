package com.example.neo4jproject.controller;

import com.example.neo4jproject.DTO.RecipeInfo;
import com.example.neo4jproject.DTO.RecipeWithAuthor;
import com.example.neo4jproject.model.Recipe;
import com.example.neo4jproject.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String getRecipeByName(@PathVariable String name, Model model) {
        RecipeInfo recipe = recipeService.getRecipeByName(name);
        if (recipe != null) {
            model.addAttribute("recipes", recipe);
            return "recipe-info.html";
        } else return "error.html";
    }

    @GetMapping("/search-by-name/page/{pageNumber}/{keyword}")
    public String getRecipesByKeyword(Model model, @PathVariable Optional<Integer> pageNumber, @PathVariable String keyword) {
        int pageSize = 20;
        Page<RecipeWithAuthor> recipes = recipeService.getRecipesByKeyword(pageNumber.orElse(0), pageSize, keyword);
        model.addAttribute("recipes", recipes);
        return "index.html";
    }
    //-----!!-----
    //Requirement 4, Nu am reusit sa il fac sa functioneze, imi apar erori cand incerc sa returnez Page<Recipe>,
    //dar cand dau return la o List<Recipe> totul merge ok.
    //-----!!-----

//    @GetMapping("/search-by-ingredient/page/{pageNumber}/{keyword}")
//    public ResponseEntity<Page<Recipe>> getRecipesByIngredient(@PathVariable String keyword, @PathVariable Optional<Integer> pageNumber) {
//        Page<Recipe> recipes = recipeService.findRecipesByIngredient(keyword,pageNumber.orElse(0), 20);
//        return ResponseEntity.ok(recipes);
//    }
}