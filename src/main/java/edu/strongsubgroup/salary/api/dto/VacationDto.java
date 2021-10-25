package edu.strongsubgroup.salary.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.strongsubgroup.salary.common.VacationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VacationDto {

    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate beginning;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate end;
    private Boolean compensation;
    private VacationStatus vacationStatus;
    private Long employeeId;
}
