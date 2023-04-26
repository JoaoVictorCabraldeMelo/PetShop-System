package com.API.Petshop.User.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.Petshop.Address.Service.AddressResponse;
import com.API.Petshop.Client.Service.ClientResponse;
import com.API.Petshop.User.model.User;
import com.API.Petshop.User.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
   
    @Autowired
    private UserRepository userRepository;

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> UserResponse.builder()
                                                        .name(user.getName())
                                                        .cpf(user.getCpf())
                                                        .roles(user.getRoles())
                                                        .client(ClientResponse.builder()
                                                                        .name(user.getClient().getName())
                                                                        .regisDate(user.getClient().getRegisterDate())
                                                                        .address(user.getClient().getAddress() == null ? null : AddressResponse.builder()
                                                                                                                                .bairro(user.getClient().getAddress().getBairro())
                                                                                                                                .cidade(user.getClient().getAddress().getCidade())
                                                                                                                                .complemento(user.getClient().getAddress().getComplemento())
                                                                                                                                .logradouro(user.getClient().getAddress().getLogradouro())
                                                                                                                                .build())            
                                                                        .build())
                            
                                                        .build()).collect(Collectors.toList());
    }


}
