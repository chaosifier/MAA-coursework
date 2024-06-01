package com.maa.as3.as3.controller;

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

import com.maa.as3.as3.entity.Comment;
import com.maa.as3.as3.entity.dto.input.CommentCreateDto;
import com.maa.as3.as3.entity.dto.output.CommentDto;
import com.maa.as3.as3.service.CommentService;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {
    @Autowired
    ModelMapper modelMapper;

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CommentDto> findAll() {
        return this.commentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable("id") int commentId) {
        var comment = this.commentService.findById(commentId);

        return ResponseEntity.ok(comment);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int saveComment(@RequestBody CommentCreateDto comment) {
        return this.commentService.create(comment);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        this.commentService.delete(id);
    }
}
