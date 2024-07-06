package com.aksoyakin.blogsystembackend.dto.request.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateRequest {

    private Long blogPostId;
    private Long commenterId;
    private String content;
}
