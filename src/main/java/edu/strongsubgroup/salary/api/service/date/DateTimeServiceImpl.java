package edu.asoldatov.salary.service.date;

import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class DateTimeServiceImpl implements DateTimeService {

    @Override
    public LocalDate getBeginningOfTheYear() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
    }

    @Override
    public LocalDate getFirstDayOfTheMonth(Month month) {
        return LocalDate.of(LocalDate.now().getYear(), month, 1).with(TemporalAdjusters.firstDayOfMonth());
    }

    @Override
    public LocalDate getLastDayOfTheMonth(Month month) {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    @Override
    public Long calculateWorkingDaysOfMonth(Month month) {
        LocalDate localDate = getFirstDayOfTheMonth(month);

        Long countWorkingDays = 0L;
        while (localDate.getDayOfMonth() < month.length(localDate.isLeapYear())) {
            if (localDate.getDayOfWeek() != DayOfWeek.SUNDAY && localDate.getDayOfWeek() != DayOfWeek.SATURDAY) {
                countWorkingDays++;
            }
            localDate = localDate.plusDays(1);
        }
        return countWorkingDays;
    }

    @Override
    public LocalDateTime convertFromDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    @Override
    public Date convertFromLocalDateTime(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public long differenceBetweenTwoDays(LocalDate start, LocalDate end) {
        return DAYS.between(start, end);
    }

    @Override
    public long countDay(LocalDate beginning, LocalDate end) {
        return Duration.between(beginning, end).toDays();
    }
}
