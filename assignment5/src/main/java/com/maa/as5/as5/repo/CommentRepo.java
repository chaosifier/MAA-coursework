package com.maa.as5.as5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maa.as5.as5.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
   
}