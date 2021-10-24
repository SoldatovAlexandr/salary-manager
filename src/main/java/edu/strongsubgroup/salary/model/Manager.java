package edu.strongsubgroup.salary.model;

import edu.strongsubgroup.salary.api.dto.EmployeeDto;
import edu.strongsubgroup.salary.common.EmployeeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue(EmployeeType.MANAGER_STRING)
public class Manager extends Employee {

    @Column(name = "count_of_projects")
    private Integer countOfProjects;

    public Manager(EmployeeDto employeeDto) {
        setFirstName(employeeDto.getFirstName());
        setCoefficient(employeeDto.getCoefficient());
        setLastName(employeeDto.getLastName());
        setPatronymic(employeeDto.getPatronymic());
        setDateOfBirth(LocalDate.now());
        setChildrenCount(employeeDto.getChildrenCount());
        setGender(employeeDto.getGender());
        setExtraVacationDays(employeeDto.getExtraVacationDays());
        setDateOfEmployment(LocalDate.now());
        setCountOfProjects(employeeDto.getCountOfProjects());
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.MANAGER;
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
                .countOfProjects(getCountOfProjects())
                .build();
    }
}
