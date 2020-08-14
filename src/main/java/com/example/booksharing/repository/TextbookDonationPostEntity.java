package com.example.booksharing.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.time.OffsetDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "textbookDonationPost")
public class TextbookDonationPostEntity {
    @Id
    @NonNull
    private String postId;
    @NonNull
    private String name;
    private String description;
    private String location;
    @NonNull
    private String subject;
    @NonNull
    private URL imageURL;
    private Set<String> tags;
    private String emailContact;
    private Integer quantity;
    private OffsetDateTime createdAt;
}
