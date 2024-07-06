package com.aksoyakin.blogsystembackend.dto.response.commenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommenterGetAllResponse {

    private Long id;
    private String name;
    private Date createdDate;
    private Date updatedDate;
}
