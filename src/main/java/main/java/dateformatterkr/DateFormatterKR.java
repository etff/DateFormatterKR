package main.java.dateformatterkr;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

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

    /**
     * Get a relative time format between the start and target date.
     *
     * @param startDate the start date
     * @param targetDate the target date
     * @return a relative time format between the start and target date
     */
    public static String toRelativeTimeFormat(LocalDate startDate, LocalDate targetDate) {
        Period period = Period.between(targetDate, startDate);

        if (period.isNegative()) {
            period = period.negated();
            if (period.getYears() > 0) {
                return period.getYears() + " 년 전";
            } else if (period.getMonths() > 0) {
                return period.getMonths() + " 개월 전";
            } else if (period.getDays() > 0) {
                return period.getDays() + " 일 전";
            }
        } else {
            if (period.getYears() > 0) {
                return period.getYears() + " 년 후";
            } else if (period.getMonths() > 0) {
                return period.getMonths() + " 개월 후";
            } else if (period.getDays() > 0) {
                return period.getDays() + " 일 후";
            }
        }
        return "오늘";
    }

    /**
     * Get a duration time format between the start and end date.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return a duration time format between the start and end date
     */
    public static String toDurationTimeFormat(LocalDate startDate, LocalDate endDate) {
        final Duration duration = Duration.ofDays(DAYS.between(startDate, endDate));
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        return String.format("%d시간 %d분 %d초", hours, minutes, seconds);
    }
}
