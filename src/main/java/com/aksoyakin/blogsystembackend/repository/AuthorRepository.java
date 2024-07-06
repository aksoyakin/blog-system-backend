package com.aksoyakin.blogsystembackend.repository;

import com.aksoyakin.blogsystembackend.entity.concretes.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author repository interface.
 * Extends JpaRepository to provide CRUD operations for Author entities.
 */

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
