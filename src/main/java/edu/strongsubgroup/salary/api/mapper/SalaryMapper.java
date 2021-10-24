package edu.strongsubgroup.salary.api.mapper;

import edu.strongsubgroup.salary.api.dto.SalaryDto;
import edu.strongsubgroup.salary.model.Salary;
import org.springframework.stereotype.Component;

@Component
public class SalaryMapper {
    public SalaryDto to(Salary salary) {
        return SalaryDto.builder()
                .id(salary.getId())
                .amount(salary.getAmount())
                .calculationDate(salary.getCalculationDate())
                .medical(salary.getMedical())
                .ndfl(salary.getNdfl())
                .recoupment(salary.getRecoupment())
                .social(salary.getSocial())
                .retirement(salary.getRetirement())
                .wage(salary.getWage())
                .build();
    }
}
