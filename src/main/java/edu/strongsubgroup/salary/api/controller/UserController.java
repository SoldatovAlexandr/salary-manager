package edu.strongsubgroup.salary.api.controller;

import edu.strongsubgroup.salary.api.dto.UserDto;
import edu.strongsubgroup.salary.api.mapper.UserMapper;
import edu.strongsubgroup.salary.model.User;
import edu.strongsubgroup.salary.service.employee.EmployeeService;
import edu.strongsubgroup.salary.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        final User user = userService.get(id);
        return userMapper.to(user);
    }

    @GetMapping("/")
    public List<UserDto> get() {
        return userService.get()
                .stream()
                .map(userMapper::to)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public UserDto add(@RequestBody UserDto userDto) {
        final User user = userMapper.to(userDto);
        user.setEmployee(employeeService.get(userDto.getEmployeeId()));
        userService.add(user);
        return userMapper.to(user);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") Long id,
                          @RequestBody UserDto userDto) {
        final User user = userMapper.to(userDto);
        return userMapper.to(userService.update(user, id));
    }
}
