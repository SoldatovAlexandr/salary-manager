package edu.asoldatov.salary.model;

import edu.asoldatov.salary.common.OverWorkingStatus;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "over_working")
public class OverWorking extends AbstractPersistable<Long> {

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OverWorkingStatus status;

    @Column(name = "hours", nullable = false)
    private BigDecimal hours;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
