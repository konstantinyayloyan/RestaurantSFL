package com.interview.task.sfl.restaurant.security;


import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final User user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    return org.springframework.security.core.userdetails.User//
        .withUsername(username)//
        .password(user.getPassword())//
        .authorities(user.getUserType())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

  public UserDetails loadUserByUUID(String UUID) throws UsernameNotFoundException {
    final User user = userRepository.findByUUID(UUID);

    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return org.springframework.security.core.userdetails.User//
            .withUsername(user.getUsername())//
            .password(user.getPassword())//
            .authorities(user.getUserType())//
            .accountExpired(false)//
            .accountLocked(false)//
            .credentialsExpired(false)//
            .disabled(false)//
            .build();
  }

}
