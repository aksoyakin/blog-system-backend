package com.aksoyakin.blogsystembackend.util.modelmapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();
}