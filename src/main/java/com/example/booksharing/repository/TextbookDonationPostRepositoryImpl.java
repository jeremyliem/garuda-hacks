package com.example.booksharing.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TextbookDonationPostRepositoryImpl implements TextbookDonationPostRepository {

    private MongoTemplate mongoTemplate;
    @Autowired
    public TextbookDonationPostRepositoryImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public TextbookDonationPostEntity addToDonationPostEntity(TextbookDonationPostEntity textbookDonationPostEntity) {
       return mongoTemplate.save(textbookDonationPostEntity);
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
    public List<TextbookDonationPostEntity> findAll() {
        return mongoTemplate.findAll(TextbookDonationPostEntity.class);
    }

    @Override
    public TextbookDonationPostEntity findByPostId(String postId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));
        return mongoTemplate.findOne(query, TextbookDonationPostEntity.class);
    }

    @Override
    public void deleteByPostId(String postId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));
        mongoTemplate.remove(postId);
    }
}
