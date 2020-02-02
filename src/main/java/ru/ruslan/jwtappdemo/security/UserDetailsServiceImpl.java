package ru.ruslan.jwtappdemo.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.ruslan.jwtappdemo.model.User;
import ru.ruslan.jwtappdemo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return user;
    }
}
