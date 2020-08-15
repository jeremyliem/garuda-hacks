package com.example.booksharing.service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import com.example.booksharing.model.TextBookDonationPost;
import com.example.booksharing.repository.TextbookDonationPostEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TextbookDonationMapper {

    TextBookDonationPost mapFromEntity(TextbookDonationPostEntity vinEntity);
    TextbookDonationPostEntity mapToEntity(TextBookDonationPost vin);
    List<TextBookDonationPost> mapFromEntity(List<TextbookDonationPostEntity> vinEntities);

    default Instant offsetDateTimeToInstant(OffsetDateTime datetime) {
        return (datetime == null) ? null : datetime.toInstant();
    }

    default OffsetDateTime instantToOffsetDateTime(Instant instant) {
        return (instant == null) ? null : OffsetDateTime.ofInstant(instant, ZoneId.of("UTC"));
    }
}
