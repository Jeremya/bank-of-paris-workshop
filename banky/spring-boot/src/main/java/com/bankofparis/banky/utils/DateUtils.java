package com.bankofparis.banky.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateUtils {

    /**
     * This class will convert String to Instant
     */
    public static Instant convertStringToInstantDate(String dateOperation) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        // catch exception if cannot cast to string
        TemporalAccessor temporalAccessor = formatter.parse(dateOperation);
        LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
        // we use Zulu zone id. We could select UTC as well.
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Z"));
        return Instant.from(zonedDateTime);
    }
}
