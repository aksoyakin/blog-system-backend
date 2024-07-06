package com.aksoyakin.blogsystembackend.dto.response.blogpost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostGetAllResponse {

    private Long id;
    private String title;
    private String content;
    private String authorName;
    private Date createdDate;
    private Date updatedDate;
}
