package com.aksoyakin.blogsystembackend.controller;

import com.aksoyakin.blogsystembackend.dto.request.comment.CommentCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.comment.CommentUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentUpdateResponse;
import com.aksoyakin.blogsystembackend.service.abstracts.CommentService;
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
@RequestMapping("api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentCreateResponse createComment(@Valid @RequestBody CommentCreateRequest request){
        return commentService.createComment(request);
    }

    @PutMapping("/{id}")
    public CommentUpdateResponse updateComment(@Valid @RequestBody CommentUpdateRequest request,
                                             @PathVariable Long id){
        request.setId(id);
        return commentService.updateComment(request);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted successfully", Boolean.TRUE);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CommentGetAllResponse> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public CommentGetByIdResponse getCommentById(@PathVariable Long id){
        return commentService.getCommentById(id);
    }
}