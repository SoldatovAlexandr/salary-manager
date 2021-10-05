package edu.asoldatov.salary.api.dto;

import edu.asoldatov.salary.common.VacationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
public class VacationDto {
    private LocalDate beginning;
    private LocalDate end;
    private Boolean compensation;
    private VacationStatus vacationStatus;
}
