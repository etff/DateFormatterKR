package main.java.dateformatterkr;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateFormatterKR {
    private static final Locale LOCALE_KOREAN = Locale.KOREAN;

    /**
     * Format a date with a given pattern.
     *
     * @param date the date
     * @param pattern the pattern
     * @return the formatted date
     */
    public static String formatDate(LocalDate date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
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
        if (dateString == null || pattern == null) {
            return null;
        }
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
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
        if (startDate == null || endDate == null) {
            return null;
        }

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
        if (startDate == null || targetDate == null) {
            return null;
        }
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
        if (startDate == null || endDate == null) {
            return null;
        }
        final Duration duration = Duration.ofDays(DAYS.between(startDate, endDate));
        final long hours = duration.toHours();
        final long minutes = duration.toMinutes() % 60;
        final long seconds = duration.getSeconds() % 60;

        return String.format("%d시간 %d분 %d초", hours, minutes, seconds);
    }

    /**
     * Get a day of week with a given date and text style.
     *
     * @param date the date
     * @param textStyle the text style
     * @return the day of week
     */
    public static String getDayOfWeek(LocalDate date, TextStyle textStyle) {
        if (date == null || textStyle == null) {
            return null;
        }

        final DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getDisplayName(textStyle, LOCALE_KOREAN);
    }
}
