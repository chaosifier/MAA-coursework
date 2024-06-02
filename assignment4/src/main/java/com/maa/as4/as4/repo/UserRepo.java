package com.maa.as4.as4.repo;

import org.springframework.stereotype.Repository;

import com.maa.as4.as4.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("select u from User u where size(u.posts) > :n")
    //@Query(value = "SELECT * FROM User u INNER JOIN Post p ON u.id = p.authorId GROUP BY u.id HAVING COUNT(p.id) > :n", nativeQuery = true)
    public List<User> findUserWithPosts(int n);
}