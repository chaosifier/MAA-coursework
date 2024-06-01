package com.maa.as2.as2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maa.as2.as2.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
}