package edu.asoldatov.salary.service.vacation;

import edu.asoldatov.salary.common.VacationStatus;
import edu.asoldatov.salary.api.dto.VacationDto;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Vacation;

public interface VacationService {

    Vacation addVacation(VacationDto vacationDto, Employee employee, VacationStatus vacationStatus);

    Vacation updateStatusVacation(Long vacationId, VacationStatus vacationStatus);
}
