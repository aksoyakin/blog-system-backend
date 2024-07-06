package com.aksoyakin.blogsystembackend.repository;

import com.aksoyakin.blogsystembackend.entity.concretes.Commenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Commenter repository interface.
 * Extends JpaRepository to provide CRUD operations for Commenter entities.
 */

@Repository
public interface CommenterRepository extends JpaRepository<Commenter, Long> {
}
