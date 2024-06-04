package com.maa.as5.as5.service;

import java.util.List;

import com.maa.as5.as5.entity.Comment;
import com.maa.as5.as5.entity.dto.input.CommentCreateDto;
import com.maa.as5.as5.entity.dto.output.CommentDto;

public interface CommentService {

    List<CommentDto> findAll();

    Comment findById(int commentId);

    int create(CommentCreateDto comment);

    void delete(int commentId);
}
