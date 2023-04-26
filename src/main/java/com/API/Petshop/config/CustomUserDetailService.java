package com.API.Petshop.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.API.Petshop.User.model.User;
import com.API.Petshop.User.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByCpf(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User with this cpf is not found" + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorityList(user));    
    }

    private List<GrantedAuthority> getAuthorityList(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
        return authorities;
    }
    
}
