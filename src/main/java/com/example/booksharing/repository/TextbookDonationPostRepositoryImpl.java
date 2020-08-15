package com.example.booksharing.repository;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

public abstract class TextbookDonationPostRepositoryImpl implements TextbookDonationPostRepository {
    private MongoTemplate mongoTemplate;
    @Autowired
    public TextbookDonationPostRepositoryImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<TextbookDonationPostEntity> findBySearch(String name, String subject, String author) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        query.addCriteria(Criteria.where("subject").is(subject));
        query.addCriteria(Criteria.where("author").is(author));
        return mongoTemplate.find(query, TextbookDonationPostEntity.class);
    }

    @Override
    public void deleteByPostId(String postId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));
        mongoTemplate.remove(postId);
    }
}
