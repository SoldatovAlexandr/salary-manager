package edu.asoldatov.salary.service.user;

import edu.asoldatov.salary.model.User;

import java.util.List;

public interface UserService {
    User get(Long id);

    List<User> get();

}
