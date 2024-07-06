package com.aksoyakin.blogsystembackend.repository;

import com.aksoyakin.blogsystembackend.entity.concretes.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * BlogPost repository interface.
 * Extends JpaRepository to provide CRUD operations for BlogPost entities.
 */

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    List<BlogPost> findByAuthorId(Long authorId);
    List<BlogPost> findByCreatedDateBetween(Date startDate, Date endDate);
}
