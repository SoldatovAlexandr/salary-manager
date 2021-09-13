package edu.asoldatov.salary.model;

import edu.asoldatov.salary.common.EmployeeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(EmployeeType.ENGINEER_STRING)
public class Engineer extends Employee{

}
