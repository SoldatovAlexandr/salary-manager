package edu.strongsubgroup.salary.api.controller;

import edu.strongsubgroup.salary.model.User;
import edu.strongsubgroup.salary.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.get();
    }

    @PostMapping("/")
    public String addUser() {
        return "user";
    }

    @PutMapping("/")
    public String updateUser() {
        return "user";
    }
}
