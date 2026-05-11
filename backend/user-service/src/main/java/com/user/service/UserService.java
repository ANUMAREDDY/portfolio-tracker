package com.user.service;

import com.user.dto.UserRequest;
import com.user.entity.User;

public interface UserService {
    User createUser(UserRequest request);
}
