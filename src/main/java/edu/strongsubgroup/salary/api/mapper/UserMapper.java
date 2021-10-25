package edu.strongsubgroup.salary.api.mapper;

import edu.strongsubgroup.salary.api.dto.UserDto;
import edu.strongsubgroup.salary.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto to(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .id(user.getId())
                .role(user.getRole())
                .employeeId(user.getEmployee().getId())
                .build();
    }

    public User to(UserDto userDto) {
        return User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
    }
}
