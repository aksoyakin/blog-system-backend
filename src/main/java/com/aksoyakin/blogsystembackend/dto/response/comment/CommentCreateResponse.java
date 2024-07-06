package com.aksoyakin.blogsystembackend.dto.response.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateResponse {

    private Long id;
    private String content;
    private String commenterName;
    private Date createdDate;
}
