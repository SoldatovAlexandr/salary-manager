package edu.asoldatov.salary.dto;

import edu.asoldatov.salary.common.VacationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class VacationDto {
    private Date beginning;
    private Date end;
    private Boolean compensation;
    private VacationStatus vacationStatus;
}
