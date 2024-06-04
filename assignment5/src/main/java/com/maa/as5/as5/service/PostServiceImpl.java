package com.maa.as5.as5.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maa.as5.as5.entity.Post;
import com.maa.as5.as5.entity.dto.input.PostCreateDto;
import com.maa.as5.as5.entity.dto.output.PostDto;
import com.maa.as5.as5.repo.PostRepo;
import com.maa.as5.as5.repo.UserRepo;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PostServiceImpl implements PostService {
  @Autowired
  ModelMapper modelMapper;

  @Autowired
  PostRepo postRepo;

  @Autowired
  UserRepo userRepo;

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
  public void create(PostCreateDto post) {
    var newPost = new Post(post.getTitle(), post.getContent());
    var user = this.userRepo.findById(post.getAuthorId()).orElse(null);
    newPost.setAuthor(user);
    this.postRepo.save(newPost);
  }

  @Override
  public List<PostDto> findPostByTitle(String title) {
    return this.postRepo.findPostByTitle(title)
        .stream()
        .map(d -> modelMapper.map(d, PostDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public void delete(int postId) {
    this.postRepo.deleteById(postId);
  }
}
