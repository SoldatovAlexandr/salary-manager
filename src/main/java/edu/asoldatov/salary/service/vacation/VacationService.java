package edu.asoldatov.salary.service.vacation;

import edu.asoldatov.salary.common.VacationStatus;
import edu.asoldatov.salary.dto.VacationDto;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Vacation;

import java.time.LocalDate;

public interface VacationService {

    Vacation addVacation(VacationDto vacationDto, Employee employee, VacationStatus vacationStatus);

    Vacation updateStatusVacation(Long vacationId, VacationStatus vacationStatus);

    Vacation changeDates(Long vacationId, LocalDate beginning, LocalDate end, VacationStatus vacationStatus);
}
