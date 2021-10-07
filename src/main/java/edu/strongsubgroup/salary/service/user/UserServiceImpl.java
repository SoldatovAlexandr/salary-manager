package edu.strongsubgroup.salary.service.user;


import edu.strongsubgroup.salary.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User get(Long id) {
        return User.builder().build();
    }

    @Override
    public List<User> get() {
        return List.of();
    }
}
