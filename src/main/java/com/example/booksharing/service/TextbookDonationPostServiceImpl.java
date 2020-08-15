package com.example.booksharing.service;

import com.example.booksharing.model.TextBookDonationPost;
import com.example.booksharing.repository.TextbookDonationPostEntity;
import com.example.booksharing.repository.TextbookDonationPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class TextbookDonationPostServiceImpl implements TextbookDonationPostService {

     private final TextbookDonationPostRepository textbookDonationPostRepository;
     private final TextbookDonationMapper textbookDonationMapper = new TextbookDonationMapperImpl();
    @Autowired
    public TextbookDonationPostServiceImpl (TextbookDonationPostRepository textbookDonationPostRepository) {
        this.textbookDonationPostRepository = textbookDonationPostRepository;
    }

    @Override
    public TextBookDonationPost addTextbookDonationPost(TextBookDonationPost textBookDonationPost) {
        log.info("Claim Textbook for PostId: {}", textBookDonationPost.getPostId());
        textBookDonationPost.setCreatedAt(OffsetDateTime.now());
        textBookDonationPost.setPostId(UUID.randomUUID().toString());
        TextbookDonationPostEntity textbookDonationPostEntity = textbookDonationMapper.mapToEntity(textBookDonationPost);
        return textbookDonationMapper.mapFromEntity(textbookDonationPostRepository.addToDonationPostEntity(textbookDonationPostEntity));
    }

    @Override
    public List<TextBookDonationPost> getAllTextbookDonationPost() {
        return textbookDonationMapper.mapFromEntity(textbookDonationPostRepository.findAll());
    }

    @Override
    public void deleteTextbookDonationPost(String postId) {
        log.info("Delete Textbook Post for PostId: {}", postId);
        textbookDonationPostRepository.deleteByPostId(postId);
    }

    @Override
    public TextBookDonationPost getTextbookDonationPost(String postId) {
        log.info("Get Textbook Details for PostId: {}", postId);
        return textbookDonationMapper.mapFromEntity(textbookDonationPostRepository.findByPostId(postId));
    }

    @Override
    public void claimTextbookDonationPost(String postId) {
        log.info("Claim Textbook for PostId: {}", postId);
        textbookDonationPostRepository.deleteByPostId(postId);
    }

    @Override
    public List<TextBookDonationPost> searchTextbookDonationPost(String name, String subject, String author) {
        return textbookDonationMapper.mapFromEntity(textbookDonationPostRepository.findBySearch(name, subject, author));
    }
}
