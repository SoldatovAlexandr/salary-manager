package edu.strongsubgroup.salary.service.user;

import edu.strongsubgroup.salary.model.User;

import java.util.List;

public interface UserService {
    User get(Long id);

    List<User> get();

}
