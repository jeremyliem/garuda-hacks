package com.example.booksharing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TextbookRequestPostRepository extends MongoRepository<TextbookRequestPostEntity, String> {

        List<TextbookRequestPostEntity> findBySearch(String name, String subject, String author);
        Optional<TextbookRequestPostEntity> findByPostId(String postId);
        void deleteByPostId(String postId);

}
