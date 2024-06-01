package com.maa.as2.as2.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.maa.as2.as2.entity.Post;
import com.maa.as2.as2.entity.dto.input.PostCreateDto;
import com.maa.as2.as2.entity.dto.output.PostDto;
import com.maa.as2.as2.service.PostService;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    @Autowired
    ModelMapper modelMapper;

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> findAll(){
        return this.postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable("id") int postId){
        var post = this.postService.findById(postId);

        return ResponseEntity.ok(post);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void savePost(@RequestBody PostCreateDto post){
        try {
            this.postService.create(post);
          } catch (Exception e) {
            System.out.println(e);
          }
    }
}
