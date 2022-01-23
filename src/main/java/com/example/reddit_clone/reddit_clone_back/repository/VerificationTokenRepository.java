package com.example.reddit_clone.reddit_clone_back.repository;

import com.example.reddit_clone.reddit_clone_back.model.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Long> {
}