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
        textBookRequestPost.setCreatedAt(OffsetDateTime.now());
        textBookRequestPost.setPostId(UUID.randomUUID().toString());
        log.info("Claim Textbook for PostId: {}", textBookRequestPost.getPostId());
        TextbookRequestPostEntity textbookRequestPostEntity = textbookRequestMapper.mapToEntity(textBookRequestPost);
        return textbookRequestMapper.mapFromEntity(textbookRequestPostRepository.addTextbookRequestPost(textbookRequestPostEntity));
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
    public TextBookRequestPost getTextbookRequestPost(String postId) {
        log.info("Get Textbook Details for PostId: {}", postId);
        return textbookRequestMapper.mapFromEntity(textbookRequestPostRepository.findByPostId(postId));
    }

    @Override
    public void claimTextbookRequestPost(String postId) {
        log.info("Claim Textbook for PostId: {}", postId);
        textbookRequestPostRepository.deleteByPostId(postId);
    }

    @Override
    public List<TextBookRequestPost> searchTextbookRequestPost(String name) {
        return textbookRequestMapper.mapFromEntity(textbookRequestPostRepository.findBySearch(name));
    }
}
