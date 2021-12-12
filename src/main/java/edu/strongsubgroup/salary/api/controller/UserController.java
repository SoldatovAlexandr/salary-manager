package edu.strongsubgroup.salary.api.controller;

import edu.strongsubgroup.salary.api.dto.UserDto;
import edu.strongsubgroup.salary.api.mapper.UserMapper;
import edu.strongsubgroup.salary.model.User;
import edu.strongsubgroup.salary.service.employee.EmployeeService;
import edu.strongsubgroup.salary.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final EmployeeService employeeService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public UserDto get(@PathVariable("id") Long id) {
        final User user = userService.getById(id);
        return userMapper.to(user);
    }

    @GetMapping("/")
    public Page<UserDto> getUsers(@PageableDefault(sort = {"firstName"}, direction = Sort.Direction.DESC, size = 20) final Pageable pageable) {
        return userService.getUsers(pageable).map(userMapper::to);
    }

    @PostMapping("/")
    public UserDto add(@Validated @RequestBody UserDto userDto) {
        final User user = userMapper.to(userDto);
        user.setEmployee(employeeService.findById(userDto.getEmployeeId()));
        userService.add(user, userDto.getRoles());
        return userMapper.to(user);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") Long id,
                         @Validated @RequestBody UserDto userDto) {
        return userMapper.to(userService.update(userDto.getRoles(), id));
    }
}
