package com.shaja.springjwt.bezkoderbackend.services.impl;

import com.shaja.springjwt.bezkoderbackend.Repositories.UserRepository;
import com.shaja.springjwt.bezkoderbackend.models.User;
import com.shaja.springjwt.bezkoderbackend.services.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminServiceImpl implements IAdminService, UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findByUsernameOREmail(String userNameorEmail) {
        Optional<User> user = userRepo.findByUsername(userNameorEmail);
        if(user.isEmpty()) {
            user = userRepo.findByEmail(userNameorEmail);
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = findByUsernameOREmail(username);
        if(optional.isEmpty()) {
            throw new UsernameNotFoundException("User with username or email" + username + "not Found");
        }
         User user = optional.get();
        return UserDetailsImpl.build(user);
    }
}
