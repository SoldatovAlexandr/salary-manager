package edu.asoldatov.salary.model;

import edu.asoldatov.salary.common.VacationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class Vacation {
    private Date beginning;
    private Date end;
    private Employee employee;
    private Boolean compensation;
    private VacationStatus status;
}
