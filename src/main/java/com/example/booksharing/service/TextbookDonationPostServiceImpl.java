package com.example.booksharing.service;

import com.example.booksharing.model.TextBookDonationPost;
import com.example.booksharing.repository.TextbookDonationPostEntity;
import com.example.booksharing.repository.TextbookDonationPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class TextbookDonationPostServiceImpl implements TextbookDonationPostService {

     TextbookDonationPostRepository textbookDonationPostRepository;
     TextbookDonationMapper textbookDonationMapper;
    @Autowired
    public TextbookDonationPostServiceImpl (TextbookDonationPostRepository textbookDonationPostRepository, TextbookDonationMapper textbookDonationMapper) {
        this.textbookDonationPostRepository = textbookDonationPostRepository;
        this.textbookDonationMapper = textbookDonationMapper;
    }

    @Override
    public TextBookDonationPost addTextbookDonationPost(TextBookDonationPost textBookDonationPost) {
        log.info("Claim Textbook for PostId: {}", textBookDonationPost.getPostId());
        textBookDonationPost.setCreatedAt(OffsetDateTime.now());
        textBookDonationPost.setPostId(UUID.randomUUID().toString());
        TextbookDonationPostEntity textbookDonationPostEntity = textbookDonationMapper.mapToEntity(textBookDonationPost);
        return textbookDonationMapper.mapFromEntity(textbookDonationPostRepository.save(textbookDonationPostEntity));
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
    public Optional<TextBookDonationPost> getTextbookDonationPost(String postId) {
        log.info("Get Textbook Details for PostId: {}", postId);
        return textbookDonationPostRepository.findByPostId(postId).map(textbookDonationMapper::mapFromEntity);
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
