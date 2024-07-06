package com.aksoyakin.blogsystembackend.controller;

import com.aksoyakin.blogsystembackend.dto.request.blogpost.BlogPostCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.blogpost.BlogPostUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostUpdateResponse;
import com.aksoyakin.blogsystembackend.service.abstracts.BlogPostService;
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
@RequestMapping("api/v1/blogposts")
@RequiredArgsConstructor
public class BlogPostController {

    private final BlogPostService blogPostService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPostCreateResponse createBlogPost(@Valid @RequestBody BlogPostCreateRequest request){
        return blogPostService.createBlogPost(request);
    }

    @PutMapping("/{id}")
    public BlogPostUpdateResponse updateBlogPost(@Valid @RequestBody BlogPostUpdateRequest request,
                                             @PathVariable Long id){
        request.setId(id);
        return blogPostService.updateBlogPost(request);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable Long id){
        blogPostService.deleteBlogPost(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted successfully", Boolean.TRUE);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BlogPostGetAllResponse> getAllBlogPosts(){
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    public BlogPostGetByIdResponse getBlogPostById(@PathVariable Long id){
        return blogPostService.getBlogPostById(id);
    }
}
