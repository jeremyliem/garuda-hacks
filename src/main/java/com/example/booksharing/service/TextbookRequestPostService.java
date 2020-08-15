package com.example.booksharing.service;

import com.example.booksharing.model.TextBookDonationPost;
import com.example.booksharing.model.TextBookRequestPost;

import java.util.List;
import java.util.Optional;

public interface TextbookRequestPostService {

    TextBookRequestPost addTextbookRequestPost(TextBookRequestPost textBookRequestPost); //done
    List<TextBookRequestPost> getAllTextbookRequestPost();
    void deleteTextbookRequestPost(String postId);
    Optional<TextBookRequestPost> getTextbookRequestPost(String postId); //done
    void claimTextbookRequestPost(String postId);
    List<TextBookRequestPost> searchTextbookRequestPost(String name, String subject, String author);
}