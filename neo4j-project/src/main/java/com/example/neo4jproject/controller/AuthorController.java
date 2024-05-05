package com.example.neo4jproject.controller;

import com.example.neo4jproject.model.Author;
import com.example.neo4jproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<List<Author>> showAllAuthors(){
        return new ResponseEntity<>(authorService.getLimitedAuthors(25), HttpStatus.OK);
    }
}
