package com.example.reddit_clone.reddit_clone_back.repository;

import com.example.reddit_clone.reddit_clone_back.model.SubReddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubredditRepository extends JpaRepository<SubReddit, Long> {
}
