package edu.strongsubgroup.salary.service.user;


import edu.strongsubgroup.salary.api.dto.RoleDto;
import edu.strongsubgroup.salary.common.UserRole;
import edu.strongsubgroup.salary.exception.DuplicateException;
import edu.strongsubgroup.salary.exception.NotFoundException;
import edu.strongsubgroup.salary.model.Role;
import edu.strongsubgroup.salary.model.User;
import edu.strongsubgroup.salary.repository.RoleRepository;
import edu.strongsubgroup.salary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    @Override
    public void add(User user, List<RoleDto> rolesDto) {
        if(userRepository.findUserByLogin(user.getLogin()).isPresent()){
            throw new DuplicateException();
        }
        user.setRoles(rolesDto == null ? getDefaultRoles() : mapToRoles(rolesDto));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(List<RoleDto> roles, Long id) {
        User user = getById(id);
        user.setRoles(mapToRoles(roles));
        userRepository.save(user);
        return user;
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
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

    private Set<Role> mapToRoles(List<RoleDto> roles) {
        return roleRepository.findAllByName(roles.stream().map(
                (role) -> UserRole.valueOf(role.getName())).collect(Collectors.toList()));
    }

    private Set<Role> getDefaultRoles() {
        return Set.of(roleRepository.findByName(UserRole.USER).orElseThrow(NotFoundException::new));
    }
}
