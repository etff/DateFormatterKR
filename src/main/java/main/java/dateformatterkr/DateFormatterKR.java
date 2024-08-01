package main.java.dateformatterkr;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatterKR {

    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    public static LocalDate parseDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
