package edu.strongsubgroup.salary.model;

import edu.strongsubgroup.salary.common.VacationStatus;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vacation")
@Entity
public class Vacation extends AbstractPersistable<Long> {

    @Column(name = "beginning")
    private LocalDate beginning;

    @Column(name = "ending")
    private LocalDate ending;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "compensation")
    private Boolean compensation;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VacationStatus status;
}
