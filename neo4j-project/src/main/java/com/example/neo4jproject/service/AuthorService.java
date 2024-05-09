package com.example.neo4jproject.service;

import com.example.neo4jproject.model.Author;
import com.example.neo4jproject.model.Recipe;
import com.example.neo4jproject.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;
    public String setAuthorToRecipe(Recipe recipe){
        Author author = authorRepository.findByRecipesName(recipe.getName());
        return author.getName();
    }
}
