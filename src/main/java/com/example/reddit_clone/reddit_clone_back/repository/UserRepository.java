package com.example.reddit_clone.reddit_clone_back.repository;

import com.example.reddit_clone.reddit_clone_back.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}