package com.aksoyakin.blogsystembackend.entity.concretes;

import com.aksoyakin.blogsystembackend.entity.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * BlogPost entity class extends BaseEntity.
 * Represents a blog post in the system.
 * Contains author, title, content.
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BLOG_POSTS")
public class BlogPost extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Embedded
    private Title title;

    @Embedded
    private Content content;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
}
