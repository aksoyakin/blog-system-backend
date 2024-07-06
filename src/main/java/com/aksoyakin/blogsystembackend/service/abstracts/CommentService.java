package com.aksoyakin.blogsystembackend.service.abstracts;

import com.aksoyakin.blogsystembackend.dto.request.comment.CommentCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.comment.CommentUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentUpdateResponse;

import java.util.List;

public interface CommentService {

    CommentCreateResponse createComment(CommentCreateRequest request);
    CommentUpdateResponse updateComment(CommentUpdateRequest request);
    void deleteComment(Long id);
    List<CommentGetAllResponse> getAllComments();
    CommentGetByIdResponse getCommentById(Long id);
}