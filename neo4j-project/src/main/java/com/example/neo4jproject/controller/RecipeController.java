package com.example.neo4jproject.controller;

import com.example.neo4jproject.DTO.RecipeDTO;
import com.example.neo4jproject.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private final RecipeService recipeService;

    //    @GetMapping("/get")
//    public ResponseEntity<List<RecipeInfo>> getRecipes(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
//        List<RecipeInfo> recipes = recipeService.getRecipesAlphabeticallyByName();
//        return new ResponseEntity<>(recipes, HttpStatus.OK);
//    }
    @GetMapping("/page/{pageNumber}")
    public Page<RecipeDTO> getRecipesByPage(@PathVariable Optional<Integer> pageNumber) {
        int pageSize = 20; // Number of recipes per page
        return recipeService.getRecipesByPage(pageNumber.orElse(0), pageSize);
    }
}
