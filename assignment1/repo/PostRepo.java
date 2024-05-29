package com.maa.as1.as1.repo;

import java.util.List;

import com.maa.as1.as1.entity.Post;
import com.maa.as1.as1.entity.dto.PostCreateDto;

public interface PostRepo {
    List<Post> findAll();
    Post getById(Long postId);
    Long savePost(PostCreateDto post);
}
