package com.example.booksharing.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {


    private final String uri;
    private final String dbName;
    private final Integer connectionTimeoutMillis;
    private final Integer socketTimeoutMillis;
    private final Integer serverSelectionTimeoutMillis;

    @Autowired
    public MongoConfig(
            @Value("${mongodb.uri}") String uri,
            @Value("${mongodb.name}") String dbName,
            @Value("${mongodb.connectionTimeoutMillis}") int connectionTimeoutMillis,
            @Value("${mongodb.socketTimeoutMillis}") int socketTimeoutMillis,
            @Value("${mongodb.serverSelectionTimeoutMillis}") int serverSelectionTimeoutMillis) {

        this.uri = uri;
        this.dbName = dbName;
        this.connectionTimeoutMillis = connectionTimeoutMillis;
        this.socketTimeoutMillis = socketTimeoutMillis;
        this.serverSelectionTimeoutMillis = serverSelectionTimeoutMillis;
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public MongoClient mongoClient() {
        MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder();
        optionsBuilder.connectTimeout(connectionTimeoutMillis);
        optionsBuilder.socketTimeout(socketTimeoutMillis);
        optionsBuilder.serverSelectionTimeout(serverSelectionTimeoutMillis);
        optionsBuilder.applicationName("vin-router-admin");
        return new MongoClient(new MongoClientURI(uri));
    }


}
