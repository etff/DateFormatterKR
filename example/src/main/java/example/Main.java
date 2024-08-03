package example;

import org.dateformatterkr.DateFormatterKR;

import java.time.LocalDate;
import java.time.format.TextStyle;

public class Main {
    public static void main(String[] args) {

        // Output: Formatted date: 2021-01-01
        LocalDate date = LocalDate.now();
        String pattern = "yyyy-MM-dd";
        String formattedDate = DateFormatterKR.formatDate(date, pattern);
        System.out.println("Formatted date: " + formattedDate);

        // Output: String to LocalDate: Parsed date: 2021-01-01
        String dateString = "2021-01-01";
        LocalDate parsedDate = DateFormatterKR.parseDate(dateString, pattern);
        System.out.println("Parsed date: " + parsedDate);

        // Output: Dates in range:
        DateFormatterKR.getDatesInRange(LocalDate.now(), LocalDate.now().plusDays(10))
                .forEach(System.out::println);

        // Output: Valid date: true or false
        boolean validDate = DateFormatterKR.isValidDate("2021-01-", pattern);
        System.out.println("Valid date: " + validDate); // false

        // Output: Relative time format
        String relativeTimeFormat = DateFormatterKR.toRelativeTimeFormat(LocalDate.now().minusDays(1), LocalDate.now());
        System.out.println("Relative time format: " + relativeTimeFormat); // 1 일 전

        // Output: Duration time format
        String durationTimeFormat = DateFormatterKR.toDurationTimeFormat(LocalDate.now().minusDays(1), LocalDate.now());
        System.out.println("Duration time format: " + durationTimeFormat); // 24시간 0분 0초

        // Output: dayOfWeek. ex) 월요일, 화요일, 수요일, 목요일, 금요일, 토요일, 일요일
        String dayOfWeek = DateFormatterKR.getDayOfWeek(LocalDate.now(), TextStyle.FULL);
        System.out.println("Day of week: " + dayOfWeek); // 현재 요일
    }
}
