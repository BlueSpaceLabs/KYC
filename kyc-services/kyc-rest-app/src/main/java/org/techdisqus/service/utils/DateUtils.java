package org.techdisqus.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    protected static final ZoneId ZONE_ID = ZoneId.of("Asia/Manila");

    protected static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");

    public static ZonedDateTime now() {
        return ZonedDateTime.now(ZONE_ID);
    }

    public static String getDate() {
        return ZonedDateTime.now(ZONE_ID).format(DATE_PATTERN);
    }

    public static String getDateTime() {
        return ZonedDateTime.now(ZONE_ID).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    }




    public static boolean isValidDateFormat(String date){
        try {
            LocalDate parsedDate =LocalDate.parse(date, DATE_PATTERN);
            return true;
        }catch (DateTimeParseException e){
            logger.error("invalid date {}", date, e);
        }

        return false;
    }
}
