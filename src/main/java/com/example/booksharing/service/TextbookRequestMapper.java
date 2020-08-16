package com.example.booksharing.service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

import com.example.booksharing.model.TextBookRequestPost;
import com.example.booksharing.repository.TextbookRequestPostEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TextbookRequestMapper {
    TextBookRequestPost mapFromEntity(TextbookRequestPostEntity textbookRequestPostEntity);
    TextbookRequestPostEntity mapToEntity(TextBookRequestPost textBookRequestPost);
    List<TextBookRequestPost> mapFromEntity(List<TextbookRequestPostEntity> textbookRequestPostEntities);

    default Instant off(OffsetDateTime datetime) {
        return (datetime == null) ? null : datetime.toInstant();
    }

    default OffsetDateTime instantToOffsetDateTime(Instant instant) {
        return (instant == null) ? null : OffsetDateTime.ofInstant(instant, ZoneId.of("UTC"));
    }
}
