package com.example.booksharing.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextbookDonationPostRepository extends MongoRepository<TextbookDonationPostEntity, String> {
    List<TextbookDonationPostEntity> findBySearch(String name, String subject, String author);
    Optional<TextbookDonationPostEntity> findByPostId(String postId);
    void deleteByPostId(String postId);
}
