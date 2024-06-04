package com.maa.as5.as5.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maa.as5.as5.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    // @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:title%")
    // @Query(value = "SELECT * FROM post p WHERE p.title LIKE '%:title%'", nativeQuery = true)
    public List<Post> findPostByTitle(@Param("title") String title);

}