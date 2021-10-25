package edu.strongsubgroup.salary.service.user;


import edu.strongsubgroup.salary.common.Role;
import edu.strongsubgroup.salary.exception.NotFoundException;
import edu.strongsubgroup.salary.model.User;
import edu.strongsubgroup.salary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public void add(User user) {
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(User fields, Long id) {
        User user = get(id);
        user.setRole(fields.getRole());
        return user;
    }
}
