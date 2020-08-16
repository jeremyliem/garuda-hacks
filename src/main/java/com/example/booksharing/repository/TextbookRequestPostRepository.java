package com.example.booksharing.repository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TextbookRequestPostRepository{
        TextbookRequestPostEntity addTextbookRequestPost(TextbookRequestPostEntity textbookRequestPostEntity);
        List<TextbookRequestPostEntity> findBySearch(String name);
        TextbookRequestPostEntity findByPostId(String postId);
        List<TextbookRequestPostEntity> findAll();
        void deleteByPostId(String postId);

}
