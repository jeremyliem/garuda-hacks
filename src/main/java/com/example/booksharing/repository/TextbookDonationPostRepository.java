package com.example.booksharing.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TextbookDonationPostRepository{
    TextbookDonationPostEntity addToDonationPostEntity(TextbookDonationPostEntity textbookDonationPostEntity);
    List<TextbookDonationPostEntity> findBySearch(String name, String subject, String author);
    List<TextbookDonationPostEntity> findAll();
    TextbookDonationPostEntity findByPostId(String postId);
    void deleteByPostId(String postId);
}
