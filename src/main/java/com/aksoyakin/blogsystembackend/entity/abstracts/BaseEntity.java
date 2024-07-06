package com.aksoyakin.blogsystembackend.entity.abstracts;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * BaseEntity class is an abstract class.
 * Contains id, created date, updated date.
 */

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    @UpdateTimestamp
    private Date updatedDate;
}
