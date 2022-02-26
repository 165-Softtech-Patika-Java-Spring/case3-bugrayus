package com.case3bugrayus.repository;

import com.case3bugrayus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameAndPhone(String username, String phone);

    boolean existsByUsername(String username);

    boolean existsByUsernameAndPhone(String username, String phone);

    boolean existsByUsernameOrPhone(String username, String phone);
}
