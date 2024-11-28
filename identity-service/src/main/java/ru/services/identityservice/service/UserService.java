package ru.services.identityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.services.identityservice.model.User;
import ru.services.identityservice.model.UserPrincipal;
import ru.services.identityservice.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        return user.map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("UserName not found: " + username));
    }

    public String addUser(User user) {
        User userAdd = new User();
        userAdd.setUserName(user.getUserName());
        userAdd.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userAdd);
        return "user added successfully";
    }
}