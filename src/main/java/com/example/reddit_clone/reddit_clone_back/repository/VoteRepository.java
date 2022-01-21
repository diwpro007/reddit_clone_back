package com.example.reddit_clone.reddit_clone_back.repository;

import com.example.reddit_clone.reddit_clone_back.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}