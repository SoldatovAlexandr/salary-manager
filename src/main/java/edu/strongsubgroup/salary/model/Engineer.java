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
@DiscriminatorValue(EmployeeType.ENGINEER_STRING)
public class Engineer extends Employee {

    @Column(name = "electrical_safety_gage")
    private Integer electricalSafetyGrade;

    @Column(name = "fire_safety_rank")
    private Integer fireSafetyRank;

    @Column(name = "information_security_rank")
    private Integer informationSecurityRank;

    public Engineer(EmployeeDto employeeDto) {
        setFirstName(employeeDto.getFirstName());
        setCoefficient(employeeDto.getCoefficient());
        setLastName(employeeDto.getLastName());
        setPatronymic(employeeDto.getPatronymic());
        setDateOfBirth(LocalDate.now());
        setChildrenCount(employeeDto.getChildrenCount());
        setGender(employeeDto.getGender());
        setDateOfEmployment(LocalDate.now());
        setElectricalSafetyGrade(employeeDto.getElectricalSafetyGrade());
        setFireSafetyRank(employeeDto.getFireSafetyRank());
        setExtraVacationDays(employeeDto.getExtraVacationDays());
        setInformationSecurityRank(employeeDto.getInformationSecurityRank());
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.ENGINEER;
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
                .electricalSafetyGrade(getElectricalSafetyGrade())
                .fireSafetyRank(getFireSafetyRank())
                .informationSecurityRank(getInformationSecurityRank())
                .build();
    }
}
