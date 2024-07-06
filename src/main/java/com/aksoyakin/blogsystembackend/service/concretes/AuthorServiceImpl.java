package com.aksoyakin.blogsystembackend.service.concretes;

import com.aksoyakin.blogsystembackend.dto.request.author.AuthorCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.author.AuthorUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.author.AuthorUpdateResponse;
import com.aksoyakin.blogsystembackend.entity.concretes.Author;
import com.aksoyakin.blogsystembackend.repository.AuthorRepository;
import com.aksoyakin.blogsystembackend.service.abstracts.AuthorService;
import com.aksoyakin.blogsystembackend.util.modelmapper.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public AuthorCreateResponse createAuthor(AuthorCreateRequest request) {
        Author author = this.modelMapperService.forRequest()
                .map(request, Author.class);

        //author.setId(0L);
        authorRepository.save(author);

        return this.modelMapperService.forResponse()
                .map(author, AuthorCreateResponse.class);
    }

    @Override
    public AuthorUpdateResponse updateAuthor(AuthorUpdateRequest request) {
        Author author = authorRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + request.getId()));

        Author updatedAuthor = modelMapperService.forRequest()
                .map(request, Author.class);

        author.setId(request.getId());
        author.setName(updatedAuthor.getName() != null ? updatedAuthor.getName() : author.getName());
        authorRepository.save(author);

        return this.modelMapperService.forRequest()
                .map(author, AuthorUpdateResponse.class);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        this.authorRepository.delete(author);
    }

    @Override
    public List<AuthorGetAllResponse> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();

        List<AuthorGetAllResponse> responses = authors.stream()
                .map(author -> modelMapperService.forResponse()
                .map(author, AuthorGetAllResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public AuthorGetByIdResponse getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        AuthorGetByIdResponse response = this.modelMapperService.forResponse()
                .map(author, AuthorGetByIdResponse.class);

        return response;
    }
}