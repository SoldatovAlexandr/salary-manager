package edu.strongsubgroup.salary.service.vacation;

import edu.strongsubgroup.salary.common.VacationStatus;
import edu.strongsubgroup.salary.api.dto.VacationDto;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Vacation;

public interface VacationService {

    Vacation addVacation(VacationDto vacationDto, Employee employee, VacationStatus vacationStatus);

    Vacation updateStatusVacation(Long vacationId, VacationStatus vacationStatus);
}
