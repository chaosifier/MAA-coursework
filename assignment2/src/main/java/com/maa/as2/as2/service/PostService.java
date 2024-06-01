package com.maa.as2.as2.service;

import java.util.List;

import com.maa.as2.as2.entity.Post;
import com.maa.as2.as2.entity.dto.input.PostCreateDto;
import com.maa.as2.as2.entity.dto.output.PostDto;

public interface PostService {

    List<PostDto> findAll();
    Post findById(int postId);  
    void create(PostCreateDto post);
}
