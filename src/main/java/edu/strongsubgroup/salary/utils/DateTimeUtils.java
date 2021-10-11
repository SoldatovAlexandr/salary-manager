//package edu.asoldatov.salary.utils;
//
//import java.time.*;
//import java.time.temporal.TemporalAdjusters;
//import java.util.Date;
//
//import static java.time.temporal.ChronoUnit.DAYS;
//
//public class DateTimeUtils {
//
//    public static LocalDate getBeginningOfTheYear() {
//        return LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
//    }
//
//    public static LocalDate getFirstDayOfTheMonth() {
//        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
//    }
//
//    public static LocalDate getLastDayOfTheMonth() {
//        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
//    }
//
//    public static Long calculateWorkingDaysOfMonth() {
//        Month month = LocalDateTime.now().getMonth().minus(1);
//        LocalDate localDate = LocalDate.now();
//
//        Long countWorkingDays = 0L;
//        while (localDate.getDayOfMonth() < month.length(localDate.isLeapYear())) {
//            if (localDate.getDayOfWeek() != DayOfWeek.SUNDAY && localDate.getDayOfWeek() != DayOfWeek.SATURDAY) {
//                countWorkingDays++;
//            }
//            localDate = localDate.plusDays(1);
//        }
//        return countWorkingDays;
//    }
//
//    public static LocalDateTime convertFromDate(Date date) {
//        return date.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDateTime();
//    }
//
//    public static Date convertFromLocalDateTime(LocalDateTime localDateTime) {
//        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//    }
//
//    public static long differenceBetweenTwoDays(LocalDate start, LocalDate end) {
//        return DAYS.between(start, end);
//    }
//
//    public static long countDay(LocalDate beginning, LocalDate end) {
//        return Duration.between(beginning, end).toDays();
//    }
//}
