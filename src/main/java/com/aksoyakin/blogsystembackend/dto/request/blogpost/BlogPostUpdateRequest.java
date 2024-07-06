package com.aksoyakin.blogsystembackend.dto.request.blogpost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostUpdateRequest {

    private Long id;
    private String title;
    private String content;
}
