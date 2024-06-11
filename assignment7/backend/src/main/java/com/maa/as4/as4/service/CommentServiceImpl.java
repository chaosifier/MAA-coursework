package com.maa.as4.as4.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maa.as4.as4.entity.Comment;
import com.maa.as4.as4.entity.dto.input.CommentCreateDto;
import com.maa.as4.as4.entity.dto.output.CommentDto;
import com.maa.as4.as4.repo.CommentRepo;
import com.maa.as4.as4.repo.PostRepo;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class CommentServiceImpl implements CommentService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    @Override
    public List<CommentDto> findAll() {
      try {
        return this.commentRepo.findAll().stream()
        .map(d -> modelMapper.map(d, CommentDto.class))
        .collect(Collectors.toList());
      } catch (Exception e) {
        return null;
      }
    }

    @Override
    public Comment findById(int commentId) {
        return this.commentRepo.findById(commentId).orElse(null);
    }

    @Override
    public int create(CommentCreateDto comment){
      var newComment = new Comment(comment.getContent());
      var post = this.postRepo.findById(comment.getPostId()).orElse(null);
      
      newComment.setPost(post);
      this.commentRepo.save(newComment);

      return newComment.getId();
    }

    @Override
    public void delete(int commentId){
      this.commentRepo.deleteById(commentId);
    }
}
