package edu.strongsubgroup.salary.model;

import edu.strongsubgroup.salary.common.EmployeeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

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

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.WORKER;
    }
}
