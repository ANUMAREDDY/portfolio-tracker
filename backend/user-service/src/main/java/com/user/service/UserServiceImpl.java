package com.user.service;

import com.user.dto.UserRequest;
import com.user.entity.User;
import com.user.mapper.UserMapper;
import com.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository repository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    @Override
    public User createUser(UserRequest request) {
        User userCreated = userMapper.toEntity(request);
        userCreated.setHashedPassword(passwordEncoder.encode(request.getPassword()));
        return repository.save(userCreated);
    }
}
