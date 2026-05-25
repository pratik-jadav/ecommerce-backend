package com.pratik.ecommerce.service;

import com.pratik.ecommerce.dto.UserRequestDto;
import com.pratik.ecommerce.entity.Role;
import com.pratik.ecommerce.entity.User;
import com.pratik.ecommerce.exception.EmailAlreadyExistsException;
import com.pratik.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(UserRequestDto dto) {

        if(repository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "Email already registered"
            );
        }

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(Role.USER)
                .build();

        return repository.save(user);
    }
}