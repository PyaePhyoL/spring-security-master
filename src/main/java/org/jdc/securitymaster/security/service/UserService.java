package org.jdc.securitymaster.security.service;

import lombok.RequiredArgsConstructor;
import org.jdc.securitymaster.dao.UserDao;
import org.jdc.securitymaster.security.ds.Role;
import org.jdc.securitymaster.security.ds.SignupModel;
import org.jdc.securitymaster.security.ds.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupModel signup) {
        User user = new User();
        user.setUsername(signup.getUsername());
        user.setPassword(passwordEncoder.encode(signup.getPassword()));

        if(signup.getRoles().length() > 0) {
            String[] roles = signup.getRoles().split(",");
            Arrays.stream(roles)
                    .map(r -> new Role(r))
                    .forEach(user::addRole);
        } else {
            user.addRole(new Role("ROLE_DUMMY"));
        }

        userDao.save(user);
    }
}
