package edu.strongsubgroup.salary.api.mapper;

import edu.strongsubgroup.salary.api.dto.UserDto;
import edu.strongsubgroup.salary.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final RoleMapper roleMapper;

    public UserDto to(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .id(user.getId())
                .roles(roleMapper.to(user.getRoles()))
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
