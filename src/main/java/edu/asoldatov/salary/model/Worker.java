package edu.asoldatov.salary.model;

import edu.asoldatov.salary.common.EmployeeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(EmployeeType.WORKER_STRING)
public class Worker extends Employee{

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.WORKER;
    }
}
