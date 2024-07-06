package com.aksoyakin.blogsystembackend.service.concretes;

import com.aksoyakin.blogsystembackend.dto.request.comment.CommentCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.comment.CommentUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.comment.CommentUpdateResponse;
import com.aksoyakin.blogsystembackend.entity.concretes.BlogPost;
import com.aksoyakin.blogsystembackend.entity.concretes.Comment;
import com.aksoyakin.blogsystembackend.entity.concretes.Commenter;
import com.aksoyakin.blogsystembackend.entity.concretes.Content;
import com.aksoyakin.blogsystembackend.repository.BlogPostRepository;
import com.aksoyakin.blogsystembackend.repository.CommentRepository;
import com.aksoyakin.blogsystembackend.repository.CommenterRepository;
import com.aksoyakin.blogsystembackend.service.abstracts.CommentService;
import com.aksoyakin.blogsystembackend.util.modelmapper.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommenterRepository commenterRepository;
    private final BlogPostRepository blogPostRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CommentCreateResponse createComment(CommentCreateRequest request) {
        Commenter commenter = commenterRepository.findById(request.getCommenterId())
                .orElseThrow(() -> new RuntimeException("Commenter not found with id: " + request.getCommenterId()));

        BlogPost blogPost = blogPostRepository.findById(request.getBlogPostId())
                .orElseThrow(() -> new RuntimeException("Blog post not found with id: " + request.getBlogPostId()));

        Comment comment = new Comment();


        Content content = new Content();
        content.setContent(request.getContent());
        comment.setContent(content);

        comment.setCommenter(commenter);
        comment.setBlogPost(blogPost);
        comment.setCreatedDate(new Date());

        commentRepository.save(comment);

        return this.modelMapperService.forResponse()
                .map(comment, CommentCreateResponse.class);
    }

    @Override
    public CommentUpdateResponse updateComment(CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + request.getId()));

        Commenter commenter = commenterRepository.findById(request.getCommenterId())
                .orElseThrow(() -> new RuntimeException("Commenter not found with id: " + request.getCommenterId()));

        BlogPost blogPost = blogPostRepository.findById(request.getBlogPostId())
                .orElseThrow(() -> new RuntimeException("Blog post not found with id: " + request.getBlogPostId()));

        Content content = new Content();
        content.setContent(request.getContent());
        comment.setContent(content);

        comment.setCommenter(commenter);
        comment.setBlogPost(blogPost);

        commentRepository.save(comment);

        return this.modelMapperService.forResponse()
                .map(comment, CommentUpdateResponse.class);

    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));

        this.commentRepository.delete(comment);
    }

    @Override
    public List<CommentGetAllResponse> getAllComments() {
        List<Comment> comments = commentRepository.findAll();

        List<CommentGetAllResponse> responses = comments.stream()
                .map(comment -> modelMapperService.forResponse()
                .map(comment, CommentGetAllResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public CommentGetByIdResponse getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));

        CommentGetByIdResponse response = this.modelMapperService.forResponse()
                .map(comment, CommentGetByIdResponse.class);

        return response;
    }
}