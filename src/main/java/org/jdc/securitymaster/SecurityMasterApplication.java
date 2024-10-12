package org.jdc.securitymaster;

import lombok.RequiredArgsConstructor;
import org.jdc.securitymaster.dao.RoleDao;
import org.jdc.securitymaster.dao.UserDao;
import org.jdc.securitymaster.security.ds.Role;
import org.jdc.securitymaster.security.ds.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityMasterApplication {

    private final PasswordEncoder passwordEncoder;
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Bean
    @Transactional
    @Profile("dev")
    public ApplicationRunner runner() {
        return args -> {
            Role role1 = new Role();
            role1.setName("ROLE_EMPLOYEES_ADMIN");

            User emma = new User();
            emma.setUsername("emma");
            emma.setPassword(passwordEncoder.encode("emma"));
            emma.addRole(role1);

            Role role2 = new Role();
            role2.setName("ROLE_CUSTOMERS_PAG_VIEW");

            Role role3 = new Role();
            role3.setName("ROLE_CUSTOMERS_READ");

            User lucas = new User();
            lucas.setUsername("lucas");
            lucas.setPassword(passwordEncoder.encode("lucas"));
            lucas.addRole(role2);
            lucas.addRole(role3);

            Role role4 = new Role();
            role4.setName("ROLE_SUPER_ADMIN");

            User john = new User();
            john.setUsername("john");
            john.setPassword(passwordEncoder.encode("john"));
            john.addRole(role4);

            userDao.save(john);
            userDao.save(emma);
            userDao.save(lucas);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityMasterApplication.class, args);
    }

}
