package org.jdc.securitymaster.security.service;

import lombok.RequiredArgsConstructor;
import org.jdc.securitymaster.dao.UserDao;
import org.jdc.securitymaster.security.ds.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username)
                        .map(SecurityUser::new)
                        .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
