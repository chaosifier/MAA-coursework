package com.maa.as5.as5.service;

import java.util.List;

import com.maa.as5.as5.entity.Post;
import com.maa.as5.as5.entity.dto.input.PostCreateDto;
import com.maa.as5.as5.entity.dto.output.PostDto;

public interface PostService {

    List<PostDto> findAll();
    Post findById(int postId);  
    void create(PostCreateDto post);
    List<PostDto> findPostByTitle(String title);
    void delete(int postId);
}
