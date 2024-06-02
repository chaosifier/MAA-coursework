package com.maa.as4.as4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maa.as4.as4.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
   
}