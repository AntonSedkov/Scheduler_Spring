package by.anthony.scheduler.controller;

import by.anthony.scheduler.model.User;
import by.anthony.scheduler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/login")
    public User getCurrentUser() {
        return service.getCurrentUser();
    }
}
