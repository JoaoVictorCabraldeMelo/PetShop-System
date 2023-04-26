package com.API.Petshop.User.services;

import java.util.Set;

import com.API.Petshop.User.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRequest {
    
    private String name;

    private String cpf;

    private Set<Role> roles;

}
