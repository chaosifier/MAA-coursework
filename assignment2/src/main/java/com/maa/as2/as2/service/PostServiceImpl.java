package com.maa.as2.as2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maa.as2.as2.entity.Post;
import com.maa.as2.as2.entity.dto.input.PostCreateDto;
import com.maa.as2.as2.entity.dto.output.PostDto;
import com.maa.as2.as2.repo.PostRepo;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PostServiceImpl implements PostService {
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
    public Post findById(int postId) {
        return this.postRepo.findById(postId).orElse(null);
    }

    @Override
    public void create(PostCreateDto post){
      var newPost = new Post(post.getTitle(), post.getContent(), post.getAuthorId());
      this.postRepo.save(newPost);
    }
}
