package com.aksoyakin.blogsystembackend.service.abstracts;

import com.aksoyakin.blogsystembackend.dto.request.author.AuthorCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.author.AuthorUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorUpdateResponse;

import java.util.List;

public interface AuthorService {

    AuthorCreateResponse createAuthor(AuthorCreateRequest request);
    AuthorUpdateResponse updateAuthor(AuthorUpdateRequest request);
    void deleteAuthor(Long id);
    List<AuthorGetAllResponse> getAllAuthors();
    AuthorGetByIdResponse getAuthorById(Long id);
}