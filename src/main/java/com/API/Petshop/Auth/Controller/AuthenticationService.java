package com.API.Petshop.Auth.Controller;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.API.Petshop.Client.Model.Client;
import com.API.Petshop.User.model.Role;
import com.API.Petshop.User.model.User;
import com.API.Petshop.User.repository.UserRepository;
import com.API.Petshop.config.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var client = Client.builder()
                            .name(request.getName())
                            .registerDate(new Date())
                            .build();

        var user = User.builder()
                        .cpf(request.getCpf())
                        .name(request.getName())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .client(client)
                        .role(Role.USER)
                        .build();
        
                        
        repository.save(user);
        var jwtToken = jwtService.generateToken(user); 
        
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getCpf(), request.getPassword())
        );
        var user = repository.findByCpf(request.getCpf())
                                .orElseThrow();
       
        var jwtToken = jwtService.generateToken(user);                

        return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
    }

}
