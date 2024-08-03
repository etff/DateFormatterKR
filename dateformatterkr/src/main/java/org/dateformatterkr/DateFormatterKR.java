package org.dateformatterkr;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DateFormatterKR {
    private static final Locale LOCALE_KOREAN = Locale.KOREAN;

    /**
     * Format a date with a given pattern.
     *
     * @param date the date
     * @param pattern the pattern
     * @return the formatted date
     */
    public static String formatDate(Temporal date, String pattern) {
        if (date == null || pattern == null) {
            throw new IllegalArgumentException("Date and pattern must not be null");
        }
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(date);
    }

    /**
     * Parse a date string with a given pattern.
     *
     * @param dateString the date string
     * @param pattern the pattern
     * @return the parsed date
     */
    public static <T extends Temporal> T parseDate(String dateString, String pattern, TemporalQuery<T> query) {
        if (dateString == null || pattern == null) {
            throw new IllegalArgumentException("Date string and pattern must not be null");
        }
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return formatter.parse(dateString, query);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date string: " + dateString, e);
        }
    }

    /**
     * Get a list of dates between the start and end date.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return a list of dates between the start and end date
     */
    public static List<Temporal> getDatesInRange(Temporal startDate, Temporal endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start and end date must not be null");
        }

        List<Temporal> dates = new ArrayList<>();
        Temporal current = startDate;

        while (ChronoUnit.DAYS.between(current, endDate) >= 0) {
            dates.add(current);
            current = current.plus(1, ChronoUnit.DAYS);
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
        if (startDate == null || targetDate == null) {
            throw new IllegalArgumentException("Start and target date must not be null");
        }

        long years = ChronoUnit.YEARS.between(targetDate, startDate);
        long months = ChronoUnit.MONTHS.between(targetDate, startDate);
        long days = ChronoUnit.DAYS.between(targetDate, startDate);

        if (years > 0) {
            return years + " 년 후";
        } else if (years < 0) {
            return (-years) + " 년 전";
        } else if (months > 0) {
            return months + " 개월 후";
        } else if (months < 0) {
            return (-months) + " 개월 전";
        } else if (days > 0) {
            return days + " 일 후";
        } else if (days < 0) {
            return (-days) + " 일 전";
        } else {
            return "오늘";
        }
    }

    /**
     * Get a duration time format between the start and end date.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return a duration time format between the start and end date
     */
    public static String toDurationTimeFormat(Temporal startDate, Temporal endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start and end date must not be null");
        }

        long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
        long totalSeconds = totalDays * 24 * 3600;
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        return String.format("%d시간 %d분 %d초", hours, minutes, seconds);
    }

    /**
     * Get a day of week with a given date and text style.
     *
     * @param date the date
     * @param textStyle the text style
     * @return the day of week
     */
    public static String getDayOfWeek(Temporal date, TextStyle textStyle) {
        if (date == null || textStyle == null) {
            throw new IllegalArgumentException("Date and text style must not be null");
        }

        int dayOfWeekValue = date.get(ChronoField.DAY_OF_WEEK);
        DayOfWeek dayOfWeek = DayOfWeek.of(dayOfWeekValue);
        return dayOfWeek.getDisplayName(textStyle, Locale.KOREAN);
    }

    /**
     * Check if the given date string is valid with the given pattern.
     *
     * @param dateString the date string
     * @param pattern pattern (ex: "yyyy-MM-dd")
     * @return true if the date string is valid, false otherwise
     */
    public static boolean isValidDate(String dateString, String pattern) {
        if (dateString == null || pattern == null) {
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            formatter.parse(dateString);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
