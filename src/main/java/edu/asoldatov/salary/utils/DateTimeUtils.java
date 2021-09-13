package edu.asoldatov.salary.utils;

import java.time.*;
import java.util.Date;

public class DateTimeUtils {

    public static Date getBeginningOfTheYear() {
        LocalDateTime localDateTime = LocalDateTime.of(
                LocalDate.now().getYear(), 1, 1, 0, 0, 0, 0);
        return convertFromLocalDateTime(localDateTime);
    }

    public static Date getFirstDayOfTheMonth(Month month) {
        LocalDateTime localDateTime = LocalDateTime.of(
                LocalDate.now().getYear(), month, 1, 0, 0, 0, 0);
        return convertFromLocalDateTime(localDateTime);
    }

    public static Date getFirstLastOfTheMonth(Month month) {
        LocalDateTime localDateTime = LocalDateTime.of(
                LocalDate.now().getYear(), month, month.length(LocalDate.now().isLeapYear()), 23 , 59, 99, 9999);
        return convertFromLocalDateTime(localDateTime);
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
