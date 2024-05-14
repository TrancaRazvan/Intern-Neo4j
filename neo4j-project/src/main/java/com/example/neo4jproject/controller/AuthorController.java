package com.example.neo4jproject.controller;

import com.example.neo4jproject.DTO.AuthorInfo;
import com.example.neo4jproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    @GetMapping("{authorName}/{pageNumber}")
    public String getAllRecipesByAuthor(@PathVariable Optional<Integer> pageNumber, @PathVariable String authorName, Model model){
        int pageSize = 20;
        Page<AuthorInfo> authorInfos = authorService.findAllRecipesByAuthorName(pageNumber.orElse(0), pageSize, authorName);
        model.addAttribute("authors", authorInfos);
        return "author-info.html";
    }
}
