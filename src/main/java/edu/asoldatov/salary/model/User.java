package edu.asoldatov.salary.model;

import edu.asoldatov.salary.common.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private Long id;
    private String login;
    private String password;
    private Role role;
    private Employee employee;
}
