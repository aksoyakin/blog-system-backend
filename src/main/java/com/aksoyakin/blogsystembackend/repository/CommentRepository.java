package com.aksoyakin.blogsystembackend.repository;

import com.aksoyakin.blogsystembackend.entity.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comment repository interface.
 * Extends JpaRepository to provide CRUD operations for Comment entities.
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogPostId(Long blogPostId);
    List<Comment> findByCommenterId(Long commenterId);
}
