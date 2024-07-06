package com.aksoyakin.blogsystembackend.entity.concretes;

import com.aksoyakin.blogsystembackend.entity.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Comment entity class. Extends the BaseEntity class.
 * Represents a comment on a blog post.
 * Contains the blog post it belongs to, the commenter, the content of the comment, and the comment date.
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMMENTS")
public class Comment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "BLOG_POST_ID", nullable = false)
    private BlogPost blogPost;

    @ManyToOne
    @JoinColumn(name = "COMMENTER_ID", nullable = false)
    private Commenter commenter;

    @Embedded
    private Content content;
}
