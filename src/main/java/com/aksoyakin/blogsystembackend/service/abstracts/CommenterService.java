package com.aksoyakin.blogsystembackend.service.abstracts;

import com.aksoyakin.blogsystembackend.dto.request.commenter.CommenterCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.commenter.CommenterUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterUpdateResponse;

import java.util.List;

public interface CommenterService {

    CommenterCreateResponse createCommenter(CommenterCreateRequest request);
    CommenterUpdateResponse updateCommenter(CommenterUpdateRequest request);
    void deleteCommenter(Long id);
    List<CommenterGetAllResponse> getAllCommenters();
    CommenterGetByIdResponse getCommenterById(Long id);
}
