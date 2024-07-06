package com.aksoyakin.blogsystembackend.service.concretes;

import com.aksoyakin.blogsystembackend.dto.request.commenter.CommenterCreateRequest;
import com.aksoyakin.blogsystembackend.dto.request.commenter.CommenterUpdateRequest;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterCreateResponse;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterGetAllResponse;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterGetByIdResponse;
import com.aksoyakin.blogsystembackend.dto.response.commenter.CommenterUpdateResponse;
import com.aksoyakin.blogsystembackend.entity.concretes.Commenter;
import com.aksoyakin.blogsystembackend.repository.CommenterRepository;
import com.aksoyakin.blogsystembackend.service.abstracts.CommenterService;
import com.aksoyakin.blogsystembackend.util.modelmapper.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommenterServiceImpl implements CommenterService {

    private final CommenterRepository commenterRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CommenterCreateResponse createCommenter(CommenterCreateRequest request) {
        Commenter commenter = this.modelMapperService.forRequest()
                .map(request, Commenter.class);

        //commenter.setId(0L);
        commenterRepository.save(commenter);

        return this.modelMapperService.forResponse()
                .map(commenter, CommenterCreateResponse.class);
    }

    @Override
    public CommenterUpdateResponse updateCommenter(CommenterUpdateRequest request) {
        Commenter commenter = commenterRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Commenter not found with id: " + request.getId()));

        Commenter updatedCommenter = modelMapperService.forRequest()
                .map(request, Commenter.class);

        commenter.setId(request.getId());
        commenter.setName(updatedCommenter.getName() != null ? updatedCommenter.getName() : commenter.getName());
        commenterRepository.save(commenter);

        return this.modelMapperService.forRequest()
                .map(commenter, CommenterUpdateResponse.class);
    }

    @Override
    public void deleteCommenter(Long id) {
        Commenter commenter = commenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commenter not found with id: " + id));

        this.commenterRepository.delete(commenter);
    }

    @Override
    public List<CommenterGetAllResponse> getAllCommenters() {
        List<Commenter> commenters = commenterRepository.findAll();

        List<CommenterGetAllResponse> responses = commenters.stream()
                .map(commenter -> modelMapperService.forResponse()
                .map(commenter, CommenterGetAllResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public CommenterGetByIdResponse getCommenterById(Long id) {
        Commenter commenter = commenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commenter not found with id: " + id));

        CommenterGetByIdResponse response = this.modelMapperService.forResponse()
                .map(commenter, CommenterGetByIdResponse.class);

        return response;
    }
}