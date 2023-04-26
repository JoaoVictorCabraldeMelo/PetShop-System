package com.API.Petshop.Pet.Service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetResponse {
    
    private RaceResponse  race;

    private ServiceResponse service;

    private Date birthday;

    private String name;
    
}
