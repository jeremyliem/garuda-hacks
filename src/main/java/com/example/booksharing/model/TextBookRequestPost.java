package com.example.booksharing.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextBookRequestPost {
    private String name;
    private String comment;
    private String location;
    private String emailContact;
    private OffsetDateTime createdAt;
    private String postId;

}
