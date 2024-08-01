package main.java.dateformatterkr;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
}
