package edu.strongsubgroup.salary.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.strongsubgroup.salary.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;
    private Role role;
    private String login;
    private String password;
    private Long employeeId;
}
