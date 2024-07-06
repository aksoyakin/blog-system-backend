package com.aksoyakin.blogsystembackend.service.concretes;

import com.aksoyakin.blogsystembackend.dto.request.blogpost.BlogPostCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.blogpost.BlogPostUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostUpdateResponse;
import com.aksoyakin.blogsystembackend.entity.concretes.Author;
import com.aksoyakin.blogsystembackend.entity.concretes.BlogPost;
import com.aksoyakin.blogsystembackend.entity.concretes.Content;
import com.aksoyakin.blogsystembackend.entity.concretes.Title;
import com.aksoyakin.blogsystembackend.repository.AuthorRepository;
import com.aksoyakin.blogsystembackend.repository.BlogPostRepository;
import com.aksoyakin.blogsystembackend.service.abstracts.BlogPostService;
import com.aksoyakin.blogsystembackend.util.modelmapper.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

    private final AuthorRepository authorRepository;
    private final BlogPostRepository blogPostRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public BlogPostCreateResponse createBlogPost(BlogPostCreateRequest request) {
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + request.getAuthorId()));

        BlogPost blogPost = new BlogPost();

        Title title = new Title();
        title.setTitle(request.getTitle());
        blogPost.setTitle(title);

        Content content = new Content();
        content.setContent(request.getContent());
        blogPost.setContent(content);

        blogPost.setAuthor(author);
        blogPost.setCreatedDate(new Date());

        blogPostRepository.save(blogPost);

        return this.modelMapperService.forResponse()
                .map(blogPost, BlogPostCreateResponse.class);
    }

    @Override
    public BlogPostUpdateResponse updateBlogPost(BlogPostUpdateRequest request) {
        BlogPost blogPost = blogPostRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Blog Post not found with id: " + request.getId()));

        Title title = new Title();
        title.setTitle(request.getTitle());
        blogPost.setTitle(title);

        Content content = new Content();
        content.setContent(request.getContent());
        blogPost.setContent(content);

        blogPostRepository.save(blogPost);

        return this.modelMapperService.forResponse()
                .map(blogPost, BlogPostUpdateResponse.class);
    }

    @Override
    public void deleteBlogPost(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog Post not found with id: " + id));

        this.blogPostRepository.delete(blogPost);
    }

    @Override
    public List<BlogPostGetAllResponse> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostRepository.findAll();

        List<BlogPostGetAllResponse> responses = blogPosts.stream()
                .map(blogPost -> modelMapperService.forResponse()
                        .map(blogPost, BlogPostGetAllResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public BlogPostGetByIdResponse getBlogPostById(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog Post not found with id: " + id));

        BlogPostGetByIdResponse response = this.modelMapperService.forResponse()
                .map(blogPost, BlogPostGetByIdResponse.class);

        return response;
    }
}