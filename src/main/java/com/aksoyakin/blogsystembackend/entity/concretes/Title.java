package com.aksoyakin.blogsystembackend.entity.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Title class.
 * Represents the title of a blog post.
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Title {

    @Column(name = "TITLE", nullable = false)
    private String title;
}
