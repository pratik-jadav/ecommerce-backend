package com.pratik.ecommerce.controller;

import com.pratik.ecommerce.dto.UserRequestDto;
import com.pratik.ecommerce.entity.User;
import com.pratik.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(
            @Valid @RequestBody UserRequestDto dto) {

        return service.register(dto);
    }
}