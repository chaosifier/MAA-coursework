package com.maa.as1.as1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maa.as1.as1.entity.Post;
import com.maa.as1.as1.entity.dto.PostCreateDto;
import com.maa.as1.as1.entity.dto.PostDto;
import com.maa.as1.as1.repo.PostRepo;

@Service
public class PostServiceImpl implements PostService {
    // private final PostRepo postRepo;

    // @Autowired
    // public PostServiceImpl(PostRepo postRepo) {
    // this.postRepo = postRepo;
    // }

    // no args constructor is reqired
    public PostServiceImpl() {
    }

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    @Override
    public List<PostDto> findAll() {
      try {
        return this.postRepo.findAll().stream()
        .map(d -> modelMapper.map(d, PostDto.class))
        .collect(Collectors.toList());
      } catch (Exception e) {
        return null;
      }
    }

    @Override
    public Post findById(long postId) {
        return this.postRepo.getById(postId);
    }

    @Override
    public Long savePost(PostCreateDto post){
      return this.postRepo.savePost(post);
    }
}
