package com.maa.as2.as2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maa.as2.as2.entity.User;
import com.maa.as2.as2.entity.dto.input.UserCreateDto;
import com.maa.as2.as2.entity.dto.output.PostDto;
import com.maa.as2.as2.entity.dto.output.UserDto;
import com.maa.as2.as2.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  ModelMapper modelMapper;

  @Autowired
  UserRepo userRepo;

  @Override
  public List<UserDto> findAll() {
    var users = this.userRepo.findAll();
    
    var res = users.stream()
        .map(d -> modelMapper.map(d, UserDto.class))
        .collect(Collectors.toList());

    return res;
  }

  @Override
  public User findById(int userId) {
    return this.userRepo.findById(userId).orElse(null);
  }

  @Override
  public void create(UserCreateDto user) {
    this.userRepo.save(new User(user.getName()));
  }

  @Override
  public List<PostDto> getuserPosts(int userId){
    var user = this.findById(userId);
    var posts = user.getPosts();
    var res = posts.stream()
    .map(d -> modelMapper.map(d, PostDto.class))
    .collect(Collectors.toList());
    return res;
  }
}
