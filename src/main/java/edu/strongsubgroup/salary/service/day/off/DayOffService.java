package edu.strongsubgroup.salary.service.day.off;

import edu.strongsubgroup.salary.api.dto.DayOffDto;
import edu.strongsubgroup.salary.common.DayOffStatus;
import edu.strongsubgroup.salary.model.DayOff;
import edu.strongsubgroup.salary.model.Employee;

public interface DayOffService {

    DayOff requestDayOff(DayOffDto dayOffDto, Employee employee);

    DayOff updateStatus(Long dayOffId, DayOffStatus dayOffStatus);
}
