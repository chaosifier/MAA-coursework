package com.maa.as5.as5.service;

import java.util.List;

import com.maa.as5.as5.entity.User;
import com.maa.as5.as5.entity.dto.input.UserCreateDto;
import com.maa.as5.as5.entity.dto.output.PostDto;
import com.maa.as5.as5.entity.dto.output.UserDto;

public interface UserService {

    List<UserDto> findAll();
    User findById(int postId);  
    void create(UserCreateDto post);
    List<PostDto> getuserPosts(int userId);
    List<UserDto> findUserWithPosts(int n);
    void delete(int userId);
}
