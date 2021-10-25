package edu.strongsubgroup.salary.api.mapper;

import edu.strongsubgroup.salary.api.dto.VacationDto;
import edu.strongsubgroup.salary.model.Vacation;
import org.springframework.stereotype.Component;

@Component
public class VacationMapper {

    public VacationDto to(Vacation vacation) {
        return VacationDto.builder()
                .id(vacation.getId())
                .employeeId(vacation.getEmployee().getId())
                .beginning(vacation.getBeginning())
                .compensation(vacation.getCompensation())
                .end(vacation.getEnding())
                .vacationStatus(vacation.getStatus())
                .build();
    }

    public Vacation to(VacationDto vacationDto) {
        return Vacation.builder()
                .beginning(vacationDto.getBeginning())
                .compensation(vacationDto.getCompensation())
                .ending(vacationDto.getEnd())
                .build();
    }
}
