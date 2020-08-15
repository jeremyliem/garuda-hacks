package com.example.booksharing.service;

import java.util.List;

import com.example.booksharing.model.TextBookRequestPost;
import com.example.booksharing.repository.TextbookRequestPostEntity;

public interface TextbookRequestMapper {
    TextBookRequestPost mapFromEntity(TextbookRequestPostEntity vinEntity);
    TextbookRequestPostEntity mapToEntity(TextBookRequestPost vin);
    List<TextBookRequestPost> mapFromEntity(List<TextbookRequestPostEntity> vinEntities);
}
