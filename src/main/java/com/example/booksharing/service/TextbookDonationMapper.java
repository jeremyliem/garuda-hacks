package com.example.booksharing.service;

import java.util.List;
import com.example.booksharing.model.TextBookDonationPost;
import com.example.booksharing.repository.TextbookDonationPostEntity;

public interface TextbookDonationMapper {

    TextBookDonationPost mapFromEntity(TextbookDonationPostEntity vinEntity);
    TextbookDonationPostEntity mapToEntity(TextBookDonationPost vin);
    List<TextBookDonationPost> mapFromEntity(List<TextbookDonationPostEntity> vinEntities);

}
