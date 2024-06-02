package com.maa.as4.as4.service;

import java.util.List;

import com.maa.as4.as4.entity.Comment;
import com.maa.as4.as4.entity.dto.input.CommentCreateDto;
import com.maa.as4.as4.entity.dto.output.CommentDto;

public interface CommentService {

    List<CommentDto> findAll();

    Comment findById(int commentId);

    int create(CommentCreateDto comment);

    void delete(int commentId);
}
