package com.example.neo4jproject.service;

import com.example.neo4jproject.DTO.AuthorInfo;
import com.example.neo4jproject.DTO.AuthorInfoMapper;
import com.example.neo4jproject.model.Author;
import com.example.neo4jproject.model.Recipe;
import com.example.neo4jproject.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    private final AuthorInfoMapper authorInfoMapper;
    public String setAuthorToRecipe(Recipe recipe){
        Author author = authorRepository.findByRecipesName(recipe.getName());
        return author.getName();
    }
    public Page<AuthorInfo> findAllRecipesByAuthorName(int pageNumber, int pageSize, String authorName){
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize);
        return authorRepository.findAllRecipesByName(pageRequest,authorName).map(authorInfoMapper);
    }
}
