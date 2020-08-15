package com.example.booksharing.service;

import com.example.booksharing.model.TextBookDonationPost;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TextbookDonationPostService {

    TextBookDonationPost addTextbookDonationPost(TextBookDonationPost textBookDonationPost);
    List<TextBookDonationPost> getAllTextbookDonationPost();
    void deleteTextbookDonationPost(String postId);
    TextBookDonationPost getTextbookDonationPost(String postId);
    void claimTextbookDonationPost(String postId);
    List<TextBookDonationPost> searchTextbookDonationPost(String name, String subject, String author);

}
