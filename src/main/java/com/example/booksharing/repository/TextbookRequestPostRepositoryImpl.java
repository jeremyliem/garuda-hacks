package com.example.booksharing.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TextbookRequestPostRepositoryImpl implements TextbookRequestPostRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public TextbookRequestPostRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Override
    public TextbookRequestPostEntity addTextbookRequestPost(TextbookRequestPostEntity textbookRequestPostEntity) {
        return mongoTemplate.save(textbookRequestPostEntity);
    }

    @Override
    public List<TextbookRequestPostEntity> findBySearch(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, TextbookRequestPostEntity.class);
    }

    @Override
    public TextbookRequestPostEntity findByPostId(String postId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));
        return mongoTemplate.findOne(query, TextbookRequestPostEntity.class);
    }

    @Override
    public List<TextbookRequestPostEntity> findAll() {
        return mongoTemplate.findAll(TextbookRequestPostEntity.class);
    }

    @Override
    public void deleteByPostId(String postId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));
        mongoTemplate.findAndRemove(query, TextbookRequestPostEntity.class);
    }
}
