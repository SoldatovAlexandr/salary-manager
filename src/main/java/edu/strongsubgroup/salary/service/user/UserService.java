package edu.strongsubgroup.salary.service.user;

import edu.strongsubgroup.salary.api.dto.RoleDto;
import edu.strongsubgroup.salary.model.User;

import java.util.List;

public interface UserService {
    User get(Long id);

    List<User> get();

    void add(User user, List<RoleDto> roles);

    User update(User user, List<RoleDto> roles, Long id);
}
