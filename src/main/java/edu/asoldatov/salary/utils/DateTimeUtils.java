package edu.asoldatov.salary.utils;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeUtils {

    public static LocalDate getBeginningOfTheYear() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
    }

    public static LocalDate getFirstDayOfTheMonth() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    public static LocalDate getLastDayOfTheMonth() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public static Long calculateWorkingDaysOfMonth() {
        Month month = LocalDateTime.now().getMonth().minus(1);
        LocalDate localDateTime = LocalDate.now();

        Long countWorkingDays = 0L;
        while (localDateTime.getDayOfMonth() < month.length(localDateTime.isLeapYear())) {
            if (localDateTime.getDayOfWeek() != DayOfWeek.SUNDAY && localDateTime.getDayOfWeek() != DayOfWeek.SATURDAY) {
                countWorkingDays++;
            }
            localDateTime = localDateTime.plusDays(1);
        }
        return countWorkingDays;
    }

    public static LocalDateTime convertFromDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static Date convertFromLocalDateTime(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static long countDay(LocalDate beginning, LocalDate end) {
        return Duration.between(beginning, end).toDays();
    }
}
