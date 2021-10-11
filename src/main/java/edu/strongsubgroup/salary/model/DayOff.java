package edu.strongsubgroup.salary.model;

import edu.asoldatov.salary.common.DayOffStatus;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "day_off")
public class DayOff extends AbstractPersistable<Long> {

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DayOffStatus status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
