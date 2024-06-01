package com.maa.as2.as2.repo;

import org.springframework.stereotype.Repository;

import com.maa.as2.as2.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}