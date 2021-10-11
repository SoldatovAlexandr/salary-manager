package edu.asoldatov.salary.service.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

public interface DateTimeService {
    LocalDate getBeginningOfTheYear();

    LocalDate getFirstDayOfTheMonth(Month month);

    LocalDate getLastDayOfTheMonth(Month month);

    Long calculateWorkingDaysOfMonth(Month month);

    LocalDateTime convertFromDate(Date date);

    Date convertFromLocalDateTime(LocalDateTime localDateTime);

    long differenceBetweenTwoDays(LocalDate start, LocalDate end);

    long countDay(LocalDate beginning, LocalDate end);
}
