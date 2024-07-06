package com.aksoyakin.blogsystembackend.controller;

import com.aksoyakin.blogsystembackend.dto.request.author.AuthorCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.author.AuthorUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorUpdateResponse;
import com.aksoyakin.blogsystembackend.service.abstracts.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorCreateResponse createAuthor(@Valid @RequestBody AuthorCreateRequest request){
        return authorService.createAuthor(request);
    }

    @PutMapping("/{id}")
    public AuthorUpdateResponse updateAuthor(@Valid @RequestBody AuthorUpdateRequest request,
                                             @PathVariable Long id){
        request.setId(id);
        return authorService.updateAuthor(request);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted successfully", Boolean.TRUE);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorGetAllResponse> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorGetByIdResponse getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }
}
