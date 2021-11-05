package edu.strongsubgroup.salary.service.user;


import edu.strongsubgroup.salary.api.dto.RoleDto;
import edu.strongsubgroup.salary.common.UserRole;
import edu.strongsubgroup.salary.exception.NotFoundException;
import edu.strongsubgroup.salary.model.User;
import edu.strongsubgroup.salary.repository.RoleRepository;
import edu.strongsubgroup.salary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public void add(User user, List<RoleDto> roles) {
        user.setRoles(roleRepository.findAllByName(roles.stream().map(
                (role) -> UserRole.valueOf(role.getName())).collect(Collectors.toList())));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(User fields, List<RoleDto> roles, Long id) {
        User user = get(id);
        user.setRoles(roleRepository.findAllByName(roles.stream().map(
                (role) -> UserRole.valueOf(role.getName())).collect(Collectors.toList())));
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(login)
                .orElseThrow(() -> {
                    log.error("User with login {} not found", login);
                    throw new UsernameNotFoundException("Пользователь не найден.");
                });
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName().name())));

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
    }
}
