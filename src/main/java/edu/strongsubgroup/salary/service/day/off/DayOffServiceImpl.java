package edu.strongsubgroup.salary.service.day.off;

import edu.strongsubgroup.salary.api.dto.DayOffDto;
import edu.strongsubgroup.salary.common.DayOffStatus;
import edu.strongsubgroup.salary.model.DayOff;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.repository.DayOffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class DayOffServiceImpl implements DayOffService {

    private final DayOffRepository dayOffRepository;

    @Override
    public DayOff requestDayOff(DayOffDto dayOffDto, Employee employee) {
        DayOff dayOff = DayOff.builder()
                .date(dayOffDto.getDate())
                .employee(employee)
                .status(DayOffStatus.REQUESTED)
                .build();
        return dayOffRepository.save(dayOff);
    }

    @Override
    public DayOff updateStatus(Long dayOffId, DayOffStatus dayOffStatus) {
        DayOff dayOff = dayOffRepository.findById(dayOffId).orElseThrow();
        dayOff.setStatus(dayOffStatus);
        dayOffRepository.save(dayOff);
        return dayOff;
    }
}
