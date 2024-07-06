package com.aksoyakin.blogsystembackend.service.abstracts;

import com.aksoyakin.blogsystembackend.dto.request.blogpost.BlogPostCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.blogpost.BlogPostUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.blogpost.BlogPostUpdateResponse;

import java.util.List;

public interface BlogPostService {

    BlogPostCreateResponse createBlogPost(BlogPostCreateRequest request);
    BlogPostUpdateResponse updateBlogPost(BlogPostUpdateRequest request);
    void deleteBlogPost(Long id);
    List<BlogPostGetAllResponse> getAllBlogPosts();
    BlogPostGetByIdResponse getBlogPostById(Long id);
}