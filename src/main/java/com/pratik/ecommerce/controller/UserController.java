package com.pratik.ecommerce.controller;

import com.pratik.ecommerce.entity.User;
import com.pratik.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping("/{Id}")
    public String getUser(@PathVariable Long Id) {
        return "User Id: " +Id;
    }

    @GetMapping("/search")
    public String search(@RequestParam String email) {
        return email;
    }
}
