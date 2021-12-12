package edu.strongsubgroup.salary.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;
    private List<RoleDto> roles;
    private Long employeeId;

    @Email(message = "incorrect.login.error")
    @NotBlank(message = "required.login.error")
    @Size(max = 64, message = "long.login.error")
    private String login;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message = "required.password.error")
    @Size(max = 64, message = "long.password.error")
    private String password;
}
