package org.jdc.securitymaster.dao;

import org.jdc.securitymaster.security.ds.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
