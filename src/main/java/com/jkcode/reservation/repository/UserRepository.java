package com.jkcode.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // additional custom methods go here
    User findByUsername(String username);
    User findByEmail(String email);
}
