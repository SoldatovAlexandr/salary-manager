package edu.asoldatov.salary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class DayOff {
    private Date date;
    private Employee employee;
}
