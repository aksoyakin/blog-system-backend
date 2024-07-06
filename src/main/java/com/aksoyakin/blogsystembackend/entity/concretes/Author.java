package com.aksoyakin.blogsystembackend.entity.concretes;

import com.aksoyakin.blogsystembackend.entity.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author entity class.
 * Represents an author in the system.
 * Contains the name of the author and a list of blog posts.
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authors")
public class Author extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogPost> blogPosts;
}
