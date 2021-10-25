package edu.strongsubgroup.salary.model;

import edu.strongsubgroup.salary.common.Role;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User extends AbstractPersistable<Long> {
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private Role role;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
