package com.aksoyakin.blogsystembackend.dto.response.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentGetByIdResponse {

    private Long id;
    private Long blogPostId;
    private String content;
    private String commenterName;
    private Date createdDate;
    private Date updatedDate;
}
