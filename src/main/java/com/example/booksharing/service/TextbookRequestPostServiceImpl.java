package com.example.booksharing.service;

import com.example.booksharing.model.TextBookRequestPost;
import com.example.booksharing.repository.TextbookRequestPostEntity;
import com.example.booksharing.repository.TextbookRequestPostRepository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
public class TextbookRequestPostServiceImpl implements TextbookRequestPostService {

    TextbookRequestPostRepository textbookRequestPostRepository;
    TextbookRequestMapper textbookRequestMapper = new TextbookRequestMapperImpl();
    @Autowired
    public TextbookRequestPostServiceImpl(TextbookRequestPostRepository textbookRequestPostRepository) {
        this.textbookRequestPostRepository = textbookRequestPostRepository;
    }

    @Override
    public TextBookRequestPost addTextbookRequestPost(TextBookRequestPost textBookRequestPost) {
        log.info("Claim Textbook for PostId: {}", textBookRequestPost.getPostId());
        textBookRequestPost.setCreatedAt(OffsetDateTime.now());
        textBookRequestPost.setPostId(UUID.randomUUID().toString());
        TextbookRequestPostEntity textbookRequestPostEntity = textbookRequestMapper.mapToEntity(textBookRequestPost);
        return textbookRequestMapper.mapFromEntity(textbookRequestPostRepository.save(textbookRequestPostEntity));
    }

    @Override
    public List<TextBookRequestPost> getAllTextbookRequestPost() {
        return textbookRequestMapper.mapFromEntity(textbookRequestPostRepository.findAll());
    }

    @Override
    public void deleteTextbookRequestPost(String postId) {
        log.info("Delete Textbook Post for PostId: {}", postId);
        textbookRequestPostRepository.deleteByPostId(postId);
    }

    @Override
    public Optional<TextBookRequestPost> getTextbookRequestPost(String postId) {
        log.info("Get Textbook Details for PostId: {}", postId);
        return textbookRequestPostRepository.findByPostId(postId).map(textbookRequestMapper::mapFromEntity);
    }

    @Override
    public void claimTextbookRequestPost(String postId) {
        log.info("Claim Textbook for PostId: {}", postId);
        textbookRequestPostRepository.deleteByPostId(postId);
    }

    @Override
    public List<TextBookRequestPost> searchTextbookRequestPost(String name, String subject, String author) {
        return textbookRequestMapper.mapFromEntity(textbookRequestPostRepository.findBySearch(name, subject, author));
    }
}
