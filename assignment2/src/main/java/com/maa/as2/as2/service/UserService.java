package com.maa.as2.as2.service;

import java.util.List;

import com.maa.as2.as2.entity.User;
import com.maa.as2.as2.entity.dto.input.UserCreateDto;
import com.maa.as2.as2.entity.dto.output.PostDto;
import com.maa.as2.as2.entity.dto.output.UserDto;

public interface UserService {

    List<UserDto> findAll();
    User findById(int postId);  
    void create(UserCreateDto post);
    List<PostDto> getuserPosts(int userId);
}
