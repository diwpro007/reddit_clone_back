package com.example.reddit_clone.reddit_clone_back.repository;

import com.example.reddit_clone.reddit_clone_back.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
