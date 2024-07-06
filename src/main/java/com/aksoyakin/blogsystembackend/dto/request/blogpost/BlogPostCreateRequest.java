package com.aksoyakin.blogsystembackend.dto.request.blogpost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostCreateRequest {

    private Long authorId;
    private String title;
    private String content;
}
