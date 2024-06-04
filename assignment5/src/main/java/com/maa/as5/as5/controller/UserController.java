package com.maa.as5.as5.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.maa.as5.as5.aspect.annotation.ExecutionTime;
import com.maa.as5.as5.entity.User;
import com.maa.as5.as5.entity.dto.input.UserCreateDto;
import com.maa.as5.as5.entity.dto.output.PostDto;
import com.maa.as5.as5.entity.dto.output.UserDto;
import com.maa.as5.as5.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @ExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> findAll() {
        try {
            return this.userService.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") int userId) {
        var user = this.userService.findById(userId);

        return ResponseEntity.ok(user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveUser(@RequestBody UserCreateDto user) {
        this.userService.create(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<PostDto> getUserPosts(@PathVariable("id") int userId) {
        try {
            return this.userService.getuserPosts(userId);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findUserWithPosts")
    public List<UserDto> findUserWithPosts(@RequestParam("n") int n) {
        return this.userService.findUserWithPosts(n);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        this.userService.delete(id);
    }
}
