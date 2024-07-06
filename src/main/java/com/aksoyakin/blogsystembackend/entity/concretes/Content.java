package com.aksoyakin.blogsystembackend.entity.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Content class.
 * Represents the content of a blog post.
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {

    @Column(name = "CONTENT", nullable = false, columnDefinition = "TEXT")
    private String content;
}
