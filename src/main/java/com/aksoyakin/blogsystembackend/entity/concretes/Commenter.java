package com.aksoyakin.blogsystembackend.entity.concretes;

import com.aksoyakin.blogsystembackend.entity.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Commenter entity class.
 * Represents a commenter in the system.
 * Contains the name of the commenter and a list of comments made by the commenter.
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMMENTERS")
public class Commenter extends BaseEntity {

    @Column(name = "NAME" ,nullable = false)
    private String name;

    @OneToMany(mappedBy = "commenter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
}
