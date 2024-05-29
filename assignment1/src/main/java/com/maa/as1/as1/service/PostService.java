package com.maa.as1.as1.service;

import java.util.List;

import com.maa.as1.as1.entity.Post;
import com.maa.as1.as1.entity.dto.PostCreateDto;
import com.maa.as1.as1.entity.dto.PostDto;

public interface PostService {

    List<PostDto> findAll();
    Post findById(long postId);  
    Long savePost(PostCreateDto post);
}
