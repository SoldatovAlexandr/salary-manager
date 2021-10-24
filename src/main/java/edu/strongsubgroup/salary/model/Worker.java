package edu.strongsubgroup.salary.model;

import edu.strongsubgroup.salary.api.dto.EmployeeDto;
import edu.strongsubgroup.salary.common.EmployeeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue(EmployeeType.WORKER_STRING)
public class Worker extends Employee {

    @Column(name = "number_of_details")
    private Integer numberOfDetails;

    @Column(name = "hazard_ratio")
    private BigDecimal hazardRatio;

    public Worker(EmployeeDto employeeDto) {
        setFirstName(employeeDto.getFirstName());
        setCoefficient(employeeDto.getCoefficient());
        setLastName(employeeDto.getLastName());
        setPatronymic(employeeDto.getPatronymic());
        setDateOfBirth(LocalDate.now());
        setChildrenCount(employeeDto.getChildrenCount());
        setGender(employeeDto.getGender());
        setDateOfEmployment(LocalDate.now());
        setNumberOfDetails(employeeDto.getNumberOfDetails());
        setExtraVacationDays(employeeDto.getExtraVacationDays());
        setHazardRatio(employeeDto.getHazardRatio());
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.WORKER;
    }

    @Override
    public EmployeeDto toDto() {
        return EmployeeDto.builder()
                .id(getId())
                .coefficient(getCoefficient())
                .firstName(getFirstName())
                .lastName(getLastName())
                .patronymic(getPatronymic())
                .dateOfBirth(getDateOfBirth())
                .childrenCount(getChildrenCount())
                .employeeType(getEmployeeType())
                .gender(getGender())
                .dateOfEmployment(getDateOfEmployment())
                .numberOfDetails(getNumberOfDetails())
                .hazardRatio(getHazardRatio())
                .build();
    }
}
