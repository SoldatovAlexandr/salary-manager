package edu.asoldatov.salary.model;

import edu.asoldatov.salary.common.EmployeeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(EmployeeType.MANAGER_STRING)
public class Manager extends Employee{

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.MANAGER;
    }
}
