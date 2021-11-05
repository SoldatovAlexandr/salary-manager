package edu.strongsubgroup.salary.model;

import edu.strongsubgroup.salary.common.UserRole;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder

@Entity
@Table(name = "roles")
public class Role extends AbstractPersistable<Long> {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private UserRole name;
}
