package com.aksoyakin.blogsystembackend.dto.response.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorGetAllResponse {

    private Long id;
    private String name;
    private Date createdDate;
    private Date updatedDate;
}
