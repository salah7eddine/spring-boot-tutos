package org.sabousaid.services.impl.sec;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
        new User(
                "meryem@gmail.com",
                "password",
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User(
                    "mum@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User(
                    "dad@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
    );

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No User was found"));
    }
}
