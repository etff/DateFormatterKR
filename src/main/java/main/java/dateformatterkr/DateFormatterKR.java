package main.java.dateformatterkr;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DateFormatterKR {

    /**
     * Format a date with a given pattern.
     *
     * @param date the date
     * @param pattern the pattern
     * @return the formatted date
     */
    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * Parse a date string with a given pattern.
     *
     * @param dateString the date string
     * @param pattern the pattern
     * @return the parsed date
     */
    public static LocalDate parseDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get a list of dates between the start and end date.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return a list of dates between the start and end date
     */
    public static List<LocalDate> getDatesInRange(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dates = new ArrayList<>();
        while (!startDate.isAfter(endDate)) {
            dates.add(startDate);
            startDate = startDate.plusDays(1);
        }
        return dates;
    }
}
