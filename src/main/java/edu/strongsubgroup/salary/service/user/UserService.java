package edu.strongsubgroup.salary.service.user;

import edu.strongsubgroup.salary.api.dto.RoleDto;
import edu.strongsubgroup.salary.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User getById(Long id);

    void add(User user, List<RoleDto> roles);

    User update(List<RoleDto> roles, Long id);

    Page<User> getUsers(Pageable pageable);
}
