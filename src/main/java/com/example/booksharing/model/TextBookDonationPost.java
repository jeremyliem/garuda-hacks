package com.example.booksharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.OffsetDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TextBookDonationPost {

    private String name;
    private String description;
    private String location;
    private String subject;
    private URL imageURL;
    private Set<String> tags;
    private String emailContact;
    private Integer quantity;
    private OffsetDateTime createdAt;

}
