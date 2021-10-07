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
@DiscriminatorValue(EmployeeType.ENGINEER_STRING)
public class Engineer extends Employee {

    @Column(name = "electrical_safety_gage")
    private Integer electricalSafetyGrade;

    @Column(name = "fire_safety_rank")
    private Integer fireSafetyRank;

    @Column(name = "information_security_rank")
    private Integer informationSecurityRank;

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.ENGINEER;
    }
}
