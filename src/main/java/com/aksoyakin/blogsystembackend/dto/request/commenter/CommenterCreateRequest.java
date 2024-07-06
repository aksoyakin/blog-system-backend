package com.aksoyakin.blogsystembackend.dto.request.commenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommenterCreateRequest {

    private String name;
}
