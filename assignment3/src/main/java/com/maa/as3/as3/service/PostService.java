package com.maa.as3.as3.service;

import java.util.List;

import com.maa.as3.as3.entity.Post;
import com.maa.as3.as3.entity.dto.input.PostCreateDto;
import com.maa.as3.as3.entity.dto.output.PostDto;

public interface PostService {

    List<PostDto> findAll();
    Post findById(int postId);  
    void create(PostCreateDto post);
    List<PostDto> findPostByTitle(String title);
    void delete(int postId);
}
