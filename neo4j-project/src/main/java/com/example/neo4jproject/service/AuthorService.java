package com.example.neo4jproject.service;

import com.example.neo4jproject.model.Author;
import com.example.neo4jproject.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;

    public List<Author> getLimitedAuthors(int limit){
        return authorRepository.findTopNAuthors(limit);
    }
}
