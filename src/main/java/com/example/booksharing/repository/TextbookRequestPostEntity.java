package com.example.booksharing.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "textbookRequestPost")
public class TextbookRequestPostEntity {
    @Id
    @NonNull
    private String postId;
    @NonNull
    private String name;
    private String description;
    private String location;
    private String emailContact;
    private Instant createdAt;
}
