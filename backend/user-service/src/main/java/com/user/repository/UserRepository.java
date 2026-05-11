package com.user.repository;

import com.user.dto.UserRequest;
import com.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRequest, Long>{

    User save(User user);

}
