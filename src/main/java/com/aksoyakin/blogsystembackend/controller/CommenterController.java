package com.aksoyakin.blogsystembackend.controller;

import com.aksoyakin.blogsystembackend.dto.request.commenter.CommenterCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.commenter.CommenterUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterUpdateResponse;
import com.aksoyakin.blogsystembackend.service.abstracts.CommenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1/commenters")
@RequiredArgsConstructor
public class CommenterController {

    private final CommenterService commenterService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommenterCreateResponse createCommenter(@Valid @RequestBody CommenterCreateRequest request){
        return commenterService.createCommenter(request);
    }

    @PutMapping("/{id}")
    public CommenterUpdateResponse updateCommenter(@Valid @RequestBody CommenterUpdateRequest request,
                                             @PathVariable Long id){
        request.setId(id);
        return commenterService.updateCommenter(request);
    }

    @DeleteMapping("/{id}")
    public void deleteCommenter(@PathVariable Long id){
        commenterService.deleteCommenter(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted successfully", Boolean.TRUE);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CommenterGetAllResponse> getAllCommenters(){
        return commenterService.getAllCommenters();
    }

    @GetMapping("/{id}")
    public CommenterGetByIdResponse getCommenterById(@PathVariable Long id){
        return commenterService.getCommenterById(id);
    }
}