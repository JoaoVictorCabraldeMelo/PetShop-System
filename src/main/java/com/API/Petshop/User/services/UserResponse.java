package com.API.Petshop.User.services;

import java.util.Set;

import com.API.Petshop.Client.Service.ClientResponse;
import com.API.Petshop.User.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
   
    private String name;

    private String cpf;

    private Set<Role> roles;

    private ClientResponse client;
}
