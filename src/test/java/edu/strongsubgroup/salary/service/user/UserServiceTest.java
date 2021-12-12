package edu.strongsubgroup.salary.service.user;

import edu.strongsubgroup.salary.api.dto.RoleDto;
import edu.strongsubgroup.salary.common.UserRole;
import edu.strongsubgroup.salary.exception.DuplicateException;
import edu.strongsubgroup.salary.exception.NotFoundException;
import edu.strongsubgroup.salary.model.Role;
import edu.strongsubgroup.salary.model.User;
import edu.strongsubgroup.salary.repository.RoleRepository;
import edu.strongsubgroup.salary.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final RoleRepository roleRepository = mock(RoleRepository.class);

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository, roleRepository);
    }

    @Test
    void getById() {
        User user = mock(User.class);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getById(1L);

        verify(userRepository).findById(1L);
        assertEquals(user, result);
    }

    @Test
    void getById_notFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> userService.getById(1L));
    }

    @Test
    void add_emptyRoles() {
        User user = new User();
        user.setLogin("login");
        Role role = mock(Role.class);

        when(userRepository.findUserByLogin("login")).thenReturn(Optional.empty());
        when(roleRepository.findByName(UserRole.USER)).thenReturn(Optional.of(role));

        userService.add(user, null);

        verify(userRepository).save(user);
        verify(roleRepository).findByName(UserRole.USER);
        verify(userRepository).findUserByLogin("login");
        assertEquals(Set.of(role), user.getRoles());
    }

    @Test
    void add() {
        User user = new User();
        user.setLogin("login");
        Role role = mock(Role.class);

        when(userRepository.findUserByLogin("login")).thenReturn(Optional.empty());
        when(roleRepository.findAllByName(List.of(UserRole.USER, UserRole.ADMIN))).thenReturn(Set.of(role));

        userService.add(user, List.of(new RoleDto("USER"), new RoleDto("ADMIN")));

        verify(userRepository).save(user);
        verify(roleRepository).findAllByName(List.of(UserRole.USER, UserRole.ADMIN));
        verify(userRepository).findUserByLogin("login");
        assertEquals(Set.of(role), user.getRoles());
    }

    @Test
    void add_duplicate() {
        User user = new User();
        user.setLogin("login");

        when(userRepository.findUserByLogin("login")).thenReturn(Optional.of(user));

        assertThrows(DuplicateException.class, () -> userService.add(user, null));
    }

    @Test
    void update() {
        User user = new User();
        Role role = mock(Role.class);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(roleRepository.findAllByName(List.of(UserRole.USER, UserRole.ADMIN))).thenReturn(Set.of(role));

        userService.update(List.of(new RoleDto("USER"), new RoleDto("ADMIN")), 1L);

        verify(userRepository).save(user);
        verify(roleRepository).findAllByName(List.of(UserRole.USER, UserRole.ADMIN));
        verify(userRepository).findById(1L);
        assertEquals(Set.of(role), user.getRoles());
    }

    @Test
    void getUsers() {
        Pageable pageable = mock(Pageable.class);
        Page<User> users = mock(Page.class);
        when(userRepository.findAll(pageable)).thenReturn(users);

        Page<User> result = userService.getUsers(pageable);

        verify(userRepository).findAll(pageable);
        assertEquals(users, result);
    }
}
