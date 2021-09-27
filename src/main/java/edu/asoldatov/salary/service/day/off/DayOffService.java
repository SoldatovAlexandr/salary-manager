package edu.asoldatov.salary.service.day.off;

import edu.asoldatov.salary.common.DayOffStatus;
import edu.asoldatov.salary.common.VacationStatus;
import edu.asoldatov.salary.dto.DayOffDto;
import edu.asoldatov.salary.model.DayOff;
import edu.asoldatov.salary.model.Employee;

public interface DayOffService {

    DayOff requestDayOff(DayOffDto dayOffDto, Employee employee);

    DayOff updateStatus(Long dayOffId, DayOffStatus dayOffStatus);
}
