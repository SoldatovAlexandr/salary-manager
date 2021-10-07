package edu.strongsubgroup.salary.model;

import edu.strongsubgroup.salary.common.EmployeeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue(EmployeeType.MANAGER_STRING)
public class Manager extends Employee {

    @Column(name = "count_of_projects")
    private Integer countOfProjects;

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.MANAGER;
    }
}
