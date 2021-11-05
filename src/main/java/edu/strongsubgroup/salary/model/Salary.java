package edu.strongsubgroup.salary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "salary")
@Entity
public class Salary extends AbstractPersistable<Long> {
    @Column(name = "wage")
    private BigDecimal wage;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "recoupment")
    private BigDecimal recoupment;

    @Column(name = "ndfl")
    private BigDecimal ndfl;

    @Column(name = "retirement")
    private BigDecimal retirement;

    @Column(name = "medical")
    private BigDecimal medical;

    @Column(name = "social")
    private BigDecimal social;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "calculation_date")
    private LocalDateTime calculationDate;
}
