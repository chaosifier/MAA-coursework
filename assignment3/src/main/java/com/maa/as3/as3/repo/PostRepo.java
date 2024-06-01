package com.maa.as3.as3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maa.as3.as3.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    // @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:title%")
    // @Query(value = "SELECT * FROM post p WHERE p.title LIKE '%:title%'", nativeQuery = true)
    public List<Post> findPostByTitle(@Param("title") String title);
}