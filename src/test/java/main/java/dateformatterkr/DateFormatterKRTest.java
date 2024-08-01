package main.java.dateformatterkr;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.TextStyle;

import static org.assertj.core.api.Assertions.assertThat;

class DateFormatterKRTest {

    @Test
    void formatDate() {
        final String pattern = "yyyy-MM-dd";
        final LocalDate date = LocalDate.of(2024, 1, 1);

        final String actual = DateFormatterKR.formatDate(date, pattern);

        assertThat(actual).isEqualTo("2024-01-01");
    }

    @Test
    void parseDate() {
        final String pattern = "yyyy-MM-dd";
        final String dateString = "2021-01-01";

        final LocalDate actual = DateFormatterKR.parseDate(dateString, pattern);

        assertThat(actual).isEqualTo(LocalDate.of(2021, 1, 1));
    }

    @Test
    void getDatesInRange() {
        final LocalDate startDate = LocalDate.of(2021, 1, 1);
        final LocalDate endDate = LocalDate.of(2021, 1, 3);

        final var actual = DateFormatterKR.getDatesInRange(startDate, endDate);

        assertThat(actual).containsExactly(startDate, LocalDate.of(2021, 1, 2), endDate);
    }

    @Test
    void toRelativeTimeFormat_year_ago() {
        final LocalDate startDate = LocalDate.of(2021, 1, 1);
        final LocalDate targetDate = LocalDate.of(2022, 1, 1);

        final String actual = DateFormatterKR.toRelativeTimeFormat(startDate, targetDate);

        assertThat(actual).isEqualTo("1 년 전");
    }

    @Test
    void toRelativeTimeFormat_month_ago() {
        final LocalDate startDate = LocalDate.of(2021, 1, 1);
        final LocalDate targetDate = LocalDate.of(2021, 2, 1);

        final String actual = DateFormatterKR.toRelativeTimeFormat(startDate, targetDate);

        assertThat(actual).isEqualTo("1 개월 전");
    }

    @Test
    void toRelativeTimeFormat_day_ago() {
        final LocalDate startDate = LocalDate.of(2021, 1, 1);
        final LocalDate targetDate = LocalDate.of(2021, 1, 2);

        final String actual = DateFormatterKR.toRelativeTimeFormat(startDate, targetDate);

        assertThat(actual).isEqualTo("1 일 전");
    }

    @Test
    void toRelativeTimeFormat_today() {
        final LocalDate startDate = LocalDate.of(2021, 1, 1);
        final LocalDate targetDate = LocalDate.of(2021, 1, 1);

        final String actual = DateFormatterKR.toRelativeTimeFormat(startDate, targetDate);

        assertThat(actual).isEqualTo("오늘");
    }

    @Test
    void toRelativeTimeFormat_tomorrow() {
        final LocalDate startDate = LocalDate.of(2021, 1, 2);
        final LocalDate targetDate = LocalDate.of(2021, 1, 1);

        final String actual = DateFormatterKR.toRelativeTimeFormat(startDate, targetDate);

        assertThat(actual).isEqualTo("1 일 후");
    }

    @Test
    void toRelativeTimeFormat_month_later() {
        final LocalDate startDate = LocalDate.of(2021, 2, 1);
        final LocalDate targetDate = LocalDate.of(2021, 1, 1);

        final String actual = DateFormatterKR.toRelativeTimeFormat(startDate, targetDate);

        assertThat(actual).isEqualTo("1 개월 후");
    }

    @Test
    void toRelativeTimeFormat_year_later() {
        final LocalDate startDate = LocalDate.of(2021, 1, 1);
        final LocalDate targetDate = LocalDate.of(2020, 1, 1);

        final String actual = DateFormatterKR.toRelativeTimeFormat(startDate, targetDate);

        assertThat(actual).isEqualTo("1 년 후");
    }

    @Test
    void toDurationTimeFormat() {
        final LocalDate startDate = LocalDate.of(2021, 1, 1);
        final LocalDate endDate = LocalDate.of(2021, 1, 3);

        final String actual = DateFormatterKR.toDurationTimeFormat(startDate, endDate);

        assertThat(actual).isEqualTo("48시간 0분 0초");
    }

    @Test
    void getDateOfWeek_text_style_full() {
        final LocalDate date = LocalDate.of(2021, 1, 1);

        final String actual = DateFormatterKR.getDayOfWeek(date, TextStyle.FULL);

        assertThat(actual).isEqualTo("금요일");
    }

    @Test
    void getDateOfWeek_text_style_short() {
        final LocalDate date = LocalDate.of(2021, 1, 1);

        final String actual = DateFormatterKR.getDayOfWeek(date, TextStyle.SHORT);

        assertThat(actual).isEqualTo("금");
    }

    @Test
    void isValidatePattern() {
        final String date = "2021-01-01";
        final String pattern = "yyyy-MM-dd";

        final boolean actual = DateFormatterKR.isValidDate(date, pattern);

        assertThat(actual).isTrue();
    }
}
